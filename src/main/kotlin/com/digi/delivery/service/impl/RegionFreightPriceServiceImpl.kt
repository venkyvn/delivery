package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.constant.MessageKey
import com.digi.delivery.dto.RegionFreightPriceDto
import com.digi.delivery.entity.RegionFreightPrice
import com.digi.delivery.exception.BusinessException
import com.digi.delivery.repository.RegionFreightPriceRepository
import com.digi.delivery.repository.RegionRepository
import com.digi.delivery.service.RegionFreightPriceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class RegionFreightPriceServiceImpl @Autowired constructor(
    val regionFreightPriceRepository: RegionFreightPriceRepository,
    val regionRepository: RegionRepository,
) :
    BaseServiceImpl<RegionFreightPriceDto, RegionFreightPrice, BaseSearchCriteria<String>, RegionFreightPriceRepository, Long>(
        regionFreightPriceRepository
    ),
    RegionFreightPriceService {

//    override fun onCreateValidate(dto: RegionFreightPriceDto) {
//        validateSameRegion(dto)
//        super.onCreateValidate(dto)
//    }
//
//    override fun onUpdateValidate(dto: RegionFreightPriceDto): RegionFreightPrice? {
//        validateSameRegion(dto)
//        return super.onUpdateValidate(dto)
//    }

//    private fun validateSameRegion(dto: RegionFreightPriceDto) {
//        dto.region?.id?.run {
//            getRepository()
//            regionFreightPriceRepository.findFirstByRegionId(this)?.run {
//                throw BusinessException(MessageKey.VALIDATION_DUPLICATE_ERR)
//            }
//        }
//    }

//    override fun update(dto: RegionFreightPriceDto): RegionFreightPriceDto {
//        val dtoId = dto.id ?: throw BusinessException(MessageKey.BAD_REQUEST)
//        val regionFreightPriceEntity =
//            getRepository().findById(dtoId).orElseThrow { BusinessException(MessageKey.BAD_REQUEST) }
//
//        regionFreightPriceFields(regionFreightPriceEntity, dto)
//        updateRegionAssociation(regionFreightPriceEntity, dto)
//
//        return toDTO(getRepository().save(regionFreightPriceEntity))
//    }

//    override fun delete(id: Long): RegionFreightPriceDto {
//        val entity = onDeleteValidate(id)
//            .apply { region = null }
//        getRepository().delete(entity)
//        return toDTO(entity)
//
//    }

//    private fun updateRegionAssociation(entity: RegionFreightPrice, dto: RegionFreightPriceDto) {
//        val newRegionId = dto.region?.id
//        val currentRegionId = entity.region?.id
//
//        when {
//            newRegionId == null && currentRegionId != null -> entity.region = null
//
//            newRegionId != null && newRegionId != currentRegionId -> {
//                entity.region =
//                    regionRepository.findById(newRegionId).orElseThrow { BusinessException(MessageKey.BAD_REQUEST) }
//            }
//        }
//    }

    private fun regionFreightPriceFields(regionFreightPrice: RegionFreightPrice, dto: RegionFreightPriceDto) {
        regionFreightPrice.apply {
            name = dto.name
            code = dto.code
            label = dto.label
            proposal = dto.proposal
            deliveryTime = dto.deliveryTime
            discount = dto.discount
        }
    }


}