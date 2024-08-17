package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.constant.MessageKey
import com.digi.delivery.dto.ReceiptDto
import com.digi.delivery.entity.Receipt
import com.digi.delivery.exception.BusinessException
import com.digi.delivery.repository.CommuneRepository
import com.digi.delivery.repository.DistrictRepository
import com.digi.delivery.repository.ProvinceRepository
import com.digi.delivery.repository.ReceiptRepository
import com.digi.delivery.service.ReceiptService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ReceiptServiceImpl @Autowired constructor(
    val receiptRepository: ReceiptRepository,
    val provinceRepository: ProvinceRepository,
    val districtRepository: DistrictRepository,
    val communeRepository: CommuneRepository,
) :
    BaseServiceImpl<ReceiptDto, Receipt, BaseSearchCriteria<String>, ReceiptRepository, Long>(
        receiptRepository
    ),
    ReceiptService {
    override fun update(dto: ReceiptDto): ReceiptDto {
        val dtoId = dto.id ?: throw BusinessException(MessageKey.BAD_REQUEST)
        val receiptEntity = getRepository().findById(dtoId).orElseThrow { BusinessException(MessageKey.BAD_REQUEST) }

        updateReceiptFields(receiptEntity, dto)
        updateProvinceAssociation(receiptEntity, dto)
        updateDistrictAssociation(receiptEntity, dto)
        updateCommuneAssociation(receiptEntity, dto)


        return toDTO(this.getRepository().save(receiptEntity))
    }

    private fun updateReceiptFields(provinceEntity: Receipt, dto: ReceiptDto) {
        provinceEntity.apply {
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
            packagingService = dto.packagingService
            packagingServiceFee = dto.packagingServiceFee
            packagingServiceQuantity = dto.packagingServiceQuantity
            totalAmount = dto.totalAmount
        }
    }

    private fun updateProvinceAssociation(entity: Receipt, dto: ReceiptDto) {
        val newProvinceId = dto.receiverProvince?.id
        val currentRegionId = entity.receiverProvince?.id

        when {
            newProvinceId == null && currentRegionId != null -> entity.receiverProvince = null

            newProvinceId != null && newProvinceId != currentRegionId -> {
                val provinceEntity =
                    provinceRepository.findById(newProvinceId).orElseThrow {
                        logger.error("Province with ID $newProvinceId not found. Throwing BusinessException.")
                        BusinessException(MessageKey.BAD_REQUEST)
                    }
                entity.receiverProvince = provinceEntity
            }
        }
    }

    private fun updateDistrictAssociation(entity: Receipt, dto: ReceiptDto) {
        val newDistrictId = dto.receiverDistrict?.id
        val currentDistrictId = entity.receiverDistrict?.id

        when {
            newDistrictId == null && currentDistrictId != null -> entity.receiverDistrict = null

            newDistrictId != null && newDistrictId != currentDistrictId -> {
                val districtEntity =
                    districtRepository.findById(newDistrictId).orElseThrow {
                        logger.error("District with ID $newDistrictId not found. Throwing BusinessException.")
                        BusinessException(MessageKey.BAD_REQUEST)
                    }
                entity.receiverDistrict = districtEntity
            }
        }
    }


    private fun updateCommuneAssociation(entity: Receipt, dto: ReceiptDto) {
        val newCommuneId = dto.receiverCommune?.id
        val currentRegionId = entity.receiverCommune?.id

        when {
            newCommuneId == null && currentRegionId != null -> entity.receiverCommune = null

            newCommuneId != null && newCommuneId != currentRegionId -> {
                val communeEntity =
                    communeRepository.findById(newCommuneId).orElseThrow {
                        logger.error("Commune with ID $newCommuneId not found. Throwing BusinessException.")
                        BusinessException(MessageKey.BAD_REQUEST)
                    }
                entity.receiverCommune = communeEntity
            }
        }
    }

}