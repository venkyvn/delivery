package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.constant.MessageKey
import com.digi.delivery.dto.ReceiptDto
import com.digi.delivery.dto.search.ReceiptSearch
import com.digi.delivery.entity.Receipt
import com.digi.delivery.exception.BusinessException
import com.digi.delivery.repository.CommuneRepository
import com.digi.delivery.repository.DistrictRepository
import com.digi.delivery.repository.ProvinceRepository
import com.digi.delivery.repository.ReceiptRepository
import com.digi.delivery.repository.spec.BaseSpec
import com.digi.delivery.service.ReceiptService
import com.digi.delivery.util.SearchHelper
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.reflect.full.memberProperties

@Service
@Transactional
class ReceiptServiceImpl @Autowired constructor(
    val receiptRepository: ReceiptRepository,
    val provinceRepository: ProvinceRepository,
    val districtRepository: DistrictRepository,
    val communeRepository: CommuneRepository,
) :
    BaseServiceImpl<ReceiptDto, Receipt, BaseSearchCriteria<ReceiptSearch>, ReceiptRepository, Long>(
        receiptRepository
    ),
    ReceiptService {

    override fun search(searchFilter: BaseSearchCriteria<ReceiptSearch>): Page<ReceiptDto> {
        logger.info("search {}", searchFilter)
        val pageable = SearchHelper.getPageableObj(searchFilter)
        var spec: Specification<Receipt> = Specification.where(null)
        val objectMapper = ObjectMapper()
        val receiptSearch = objectMapper.convertValue(searchFilter.searchCriteria, ReceiptSearch::class.java)
        receiptSearch?.let { search ->
            val nonNullProperties = ReceiptSearch::class.memberProperties.filter { it.get(search) != null }
            for (property in nonNullProperties) {
                val fieldName = property.name
                val fieldValue = property.get(search)
                logger.info("Processing field: {}, Value: {}", fieldName, fieldValue)

                when (fieldValue) {
                    is String -> {
                        if (fieldValue.isNotBlank()) {
                            spec = spec.and(BaseSpec<Receipt>().searchByFieldValue(fieldName, fieldValue))
                        }
                    }

                    is Enum<*> -> {
                        spec = spec.and(BaseSpec<Receipt>().searchByFieldValue(fieldName, fieldValue))
                        // Directly use the enum value in the search

                    }

                    is Collection<*> -> {
                        var combinedNullSpec: Specification<Receipt> = Specification.where(null)
                        // Handle multiple values for the same field (e.g., ["PENDING", "IN_PROGRESS"])
                        val combinedSpec = fieldValue.filterNotNull().fold(combinedNullSpec) { accSpec, value ->
                            accSpec.or(BaseSpec<Receipt>().searchByFieldValue(fieldName, value))
                        }

                        spec = spec.and(combinedSpec)
                    }
                    // Add more type checks if needed
                }
            }
        }

        val page = this.getRepository().findAll(spec, pageable)
        logger.info("Total elements found: {}, Content size: {}", page.totalElements, page.content.size)
        return PageImpl(toDTOs(page.content), pageable, page.totalElements)
    }

    override fun update(dto: ReceiptDto): ReceiptDto {
        val dtoId = dto.id ?: throw BusinessException(MessageKey.BAD_REQUEST)
        var entity =
            getRepository().findById(dtoId).orElseThrow { BusinessException(MessageKey.BAD_REQUEST) }

        updateFields(entity, dto)
        updateProvince(entity, dto)
        updateDistrict(entity, dto)
        updateCommune(entity, dto)
        return toDTO(this.getRepository().save(entity))
    }

    private fun updateProvince(entity: Receipt, dto: ReceiptDto) {
        val newProvince = dto.receiverProvince?.id
        val currentProvince = entity.receiverProvince?.id

        when {
            newProvince == null && currentProvince != null -> entity.receiverProvince = null

            newProvince != null && newProvince != currentProvince -> {
                val provinceEntity =
                    provinceRepository.findById(newProvince).orElseThrow {
                        logger.error("Province with ID $newProvince not found. Throwing BusinessException.")
                        BusinessException(MessageKey.BAD_REQUEST)
                    }
                entity.receiverProvince = provinceEntity
            }
        }
    }

    private fun updateDistrict(entity: Receipt, dto: ReceiptDto) {
        val newDistrict = dto.receiverDistrict?.id
        val currentDistrict = entity.receiverDistrict?.id

        when {
            newDistrict == null && currentDistrict != null -> entity.receiverDistrict = null

            newDistrict != null && newDistrict != currentDistrict -> {
                val districtEntity =
                    districtRepository.findById(newDistrict).orElseThrow {
                        logger.error("District with ID $newDistrict not found. Throwing BusinessException.")
                        BusinessException(MessageKey.BAD_REQUEST)
                    }
                entity.receiverDistrict = districtEntity
            }
        }
    }

    private fun updateCommune(entity: Receipt, dto: ReceiptDto) {
        val newCommune = dto.receiverCommune?.id
        val currentCommune = entity.receiverCommune?.id

        when {
            newCommune == null && currentCommune != null -> entity.receiverCommune = null

            newCommune != null && newCommune != currentCommune -> {
                val communeEntity =
                    communeRepository.findById(newCommune).orElseThrow {
                        logger.error("Commune with ID $newCommune not found. Throwing BusinessException.")
                        BusinessException(MessageKey.BAD_REQUEST)
                    }
                entity.receiverCommune = communeEntity
            }
        }
    }


    private fun updateFields(entity: Receipt, dto: ReceiptDto) {
        entity.apply {
            orderNumber = dto.orderNumber
            receiptCode = dto.receiptCode
            senderName = dto.senderName
            senderIdCard = dto.senderIdCard
            senderPhone = dto.senderPhone
            senderAddress = dto.senderAddress
            receiverName = dto.receiverName
            receiverIdCard = dto.receiverIdCard
            receiverPhone = dto.receiverPhone
            receiverAddress = dto.receiverAddress
            itemName = dto.itemName
            itemValue = dto.itemValue
            itemLength = dto.itemLength
            itemWidth = dto.itemWidth
            itemHeight = dto.itemHeight
            itemWeight = dto.itemWeight
            itemFragile = dto.itemFragile
            itemQuantity = dto.itemQuantity
            serviceFee = dto.serviceFee
            packagingServices = dto.packagingServices!!
            packagingServiceFee = dto.packagingServiceFee
            packagingServiceQuantity = dto.packagingServiceQuantity
            totalAmount = dto.totalAmount
            subPackages = dto.subPackages!!
            billStatus = dto.billStatus
            settlementStatus = dto.settlementStatus
        }
    }
}