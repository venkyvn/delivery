package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.constant.MessageKey
import com.digi.delivery.dto.RegionRateDto
import com.digi.delivery.entity.RegionRate
import com.digi.delivery.exception.BusinessException
import com.digi.delivery.repository.RegionFreightPriceRepository
import com.digi.delivery.repository.RegionRateRepository
import com.digi.delivery.service.RegionRateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class RegionRateServiceImpl @Autowired constructor(
    regionRate: RegionRateRepository,
    val regionFreightPriceRepository: RegionFreightPriceRepository,
) :
    BaseServiceImpl<RegionRateDto, RegionRate, BaseSearchCriteria<String>, RegionRateRepository, Long>(regionRate),
    RegionRateService {

    override fun update(dto: RegionRateDto): RegionRateDto {
        val dtoId = dto.id ?: throw BusinessException(MessageKey.BAD_REQUEST)
        val regionRateEntity =
            getRepository().findById(dtoId).orElseThrow { BusinessException(MessageKey.BAD_REQUEST) }

        updateRegionRateFields(regionRateEntity, dto)
        updateRegionFreightPriceAssociation(regionRateEntity, dto)

        return toDTO(getRepository().save(regionRateEntity))
    }

    private fun updateRegionRateFields(entity: RegionRate, dto: RegionRateDto) {
        entity.apply {
            name = dto.name
            label = dto.label
            fromKg = dto.fromKg
            toKg = dto.toKg
            price = dto.price
            additionalPrice = dto.additionalPrice
            additionalWeight = dto.additionalWeight
            note = dto.note
        }
    }

    private fun updateRegionFreightPriceAssociation(entity: RegionRate, dto: RegionRateDto) {
        val newRegionFreightPriceId = dto.regionFreightPrice?.id
        val currentRegionFreightPriceId = entity.regionFreightPrice?.id

        when {
            newRegionFreightPriceId == null && currentRegionFreightPriceId != null -> entity.regionFreightPrice = null

            newRegionFreightPriceId != null && newRegionFreightPriceId != currentRegionFreightPriceId -> {
                entity.regionFreightPrice =
                    regionFreightPriceRepository.findById(newRegionFreightPriceId)
                        .orElseThrow { BusinessException(MessageKey.BAD_REQUEST) }
            }
        }
    }

}