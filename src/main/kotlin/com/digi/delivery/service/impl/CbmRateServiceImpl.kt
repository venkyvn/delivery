package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.constant.MessageKey
import com.digi.delivery.dto.CbmRateDto
import com.digi.delivery.dto.RegionFreightPriceDto
import com.digi.delivery.entity.CbmRate
import com.digi.delivery.exception.BusinessException
import com.digi.delivery.repository.CbmFreightPriceRepository
import com.digi.delivery.repository.CbmRateRepository
import com.digi.delivery.service.CbmRateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CbmRateServiceImpl @Autowired constructor(
    cbmRate: CbmRateRepository,
    val cbmFreightPriceRepository: CbmFreightPriceRepository,
) :
    BaseServiceImpl<CbmRateDto, CbmRate, BaseSearchCriteria<String>, CbmRateRepository, Long>(cbmRate),
    CbmRateService {

    override fun update(dto: CbmRateDto): CbmRateDto {
        val dtoId = dto.id ?: throw BusinessException(MessageKey.BAD_REQUEST)
        val regionRateEntity =
            getRepository().findById(dtoId).orElseThrow { BusinessException(MessageKey.BAD_REQUEST) }

        updateCbmRateFields(regionRateEntity, dto)
        UpdateCbmFreightAssociation(regionRateEntity, dto)

        return toDTO(getRepository().save(regionRateEntity))
    }

    override fun delete(id: Long): CbmRateDto {
        val entity = onDeleteValidate(id)
            .apply { cbmFreightPrice = null }
        getRepository().delete(entity)
        return toDTO(entity)
    }

    private fun updateCbmRateFields(entity: CbmRate, dto: CbmRateDto) {
        entity.apply {
            fromVolume = dto.fromVolume
            toVolume = dto.toVolume
            additionalVolume = dto.additionalVolume
            price = dto.price
            additionalPrice = dto.additionalPrice
            note = dto.note
        }
    }

    private fun UpdateCbmFreightAssociation(entity: CbmRate, dto: CbmRateDto) {
        val newCbmFreightPriceId = dto.cbmFreightPrice?.id
        val currentCbmFreightPriceId = entity.cbmFreightPrice?.id

        when {
            newCbmFreightPriceId == null && currentCbmFreightPriceId != null -> entity.cbmFreightPrice = null

            newCbmFreightPriceId != null && newCbmFreightPriceId != currentCbmFreightPriceId -> {
                entity.cbmFreightPrice =
                    cbmFreightPriceRepository.findById(newCbmFreightPriceId)
                        .orElseThrow { BusinessException(MessageKey.BAD_REQUEST) }
            }
        }
    }

}