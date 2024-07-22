package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.constant.MessageKey
import com.digi.delivery.dto.RegionDto
import com.digi.delivery.entity.Region
import com.digi.delivery.exception.BusinessException
import com.digi.delivery.repository.RegionRepository
import com.digi.delivery.service.RegionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class RegionServiceImpl @Autowired constructor(
    region: RegionRepository,
) :
    BaseServiceImpl<RegionDto, Region, BaseSearchCriteria<String>, RegionRepository, Long>(
        region
    ),
    RegionService {

    override fun update(dto: RegionDto): RegionDto {
        val dtoId = dto.id ?: throw BusinessException(MessageKey.BAD_REQUEST)
        val regionFreightPriceEntity =
            getRepository().findById(dtoId).orElseThrow { BusinessException(MessageKey.BAD_REQUEST) }

        updateRegionFields(regionFreightPriceEntity, dto)
        return toDTO(getRepository().save(regionFreightPriceEntity))
    }

    private fun updateRegionFields(regionFreightPrice: Region, dto: RegionDto) {
        regionFreightPrice.apply {
            name = dto.name
            code = dto.code
        }
    }

}