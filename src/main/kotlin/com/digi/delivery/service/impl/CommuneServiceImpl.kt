package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.constant.MessageKey
import com.digi.delivery.dto.CommuneDto
import com.digi.delivery.entity.Commune
import com.digi.delivery.exception.BusinessException
import com.digi.delivery.repository.CommuneRepository
import com.digi.delivery.repository.DistrictRepository
import com.digi.delivery.service.CommuneService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CommuneServiceImpl @Autowired constructor(
    val communeRepository: CommuneRepository,
    val districtRepository: DistrictRepository,
) :
    BaseServiceImpl<CommuneDto, Commune, BaseSearchCriteria<String>, CommuneRepository, Long>(communeRepository),
    CommuneService {
    override fun findAll(): List<CommuneDto> {
        return this.getRepository().findAllCommuneLite().stream().map { lite ->
            CommuneDto().apply {
                id = lite.id
                code = lite.code
                name = lite.name
                label = lite.label
                km = lite.km
                shipmentType = lite.shipmentType
                percentRate = lite.percentRate
            }
        }.toList()
    }

    override fun update(dto: CommuneDto): CommuneDto {
        val dtoId = dto.id ?: throw BusinessException(MessageKey.BAD_REQUEST)
        val communeEntity =
            getRepository().findById(dtoId).orElseThrow { BusinessException(MessageKey.BAD_REQUEST) }

        updateCommuneFields(communeEntity, dto)
        updateDistrictAssociation(communeEntity, dto)

        return toDTO(getRepository().save(communeEntity))
    }

    //able to remove this one
    override fun delete(id: Long): CommuneDto {
        val entity = onDeleteValidate(id)
            .apply { district = null }
        getRepository().delete(entity)
        return toDTO(entity)
    }

    private fun updateCommuneFields(districtEntity: Commune, dto: CommuneDto) {
        districtEntity.apply {
            code = dto.code
            name = dto.name
            label = dto.label
            km = dto.km
            shipmentType = dto.shipmentType
            percentRate = dto.percentRate
        }
    }

    private fun updateDistrictAssociation(entity: Commune, dto: CommuneDto) {
        val newDistrictId = dto.district?.id
        val currentDistrictId = entity.district?.id

        when {
            newDistrictId == null && currentDistrictId != null -> entity.district = null

            newDistrictId != null && newDistrictId != currentDistrictId -> {
                entity.district =
                    districtRepository.findById(newDistrictId).orElseThrow { BusinessException(MessageKey.BAD_REQUEST) }
            }
        }
    }

}