package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.constant.MessageKey
import com.digi.delivery.dto.DistrictDto
import com.digi.delivery.dto.ProvinceDto
import com.digi.delivery.entity.District
import com.digi.delivery.exception.BusinessException
import com.digi.delivery.repository.DistrictRepository
import com.digi.delivery.repository.ProvinceRepository
import com.digi.delivery.service.DistrictService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class DistrictServiceImpl @Autowired constructor(
    districtRepository: DistrictRepository,
    val provinceRepository: ProvinceRepository,
) :
    BaseServiceImpl<DistrictDto, District, BaseSearchCriteria<String>, DistrictRepository, Long>(districtRepository),
    DistrictService {

    override fun findAll(): List<DistrictDto> {
        return this.getRepository().findAllDistrictLite().stream().map { lite ->
            DistrictDto().apply {
                id = lite.id
                code = lite.code
                name = lite.name
            }
        }.toList()
    }

    override fun update(dto: DistrictDto): DistrictDto {
        val dtoId = dto.id ?: throw BusinessException(MessageKey.BAD_REQUEST)
        val districtEntity =
            getRepository().findById(dtoId).orElseThrow { BusinessException(MessageKey.BAD_REQUEST) }

        updateDistrictFields(districtEntity, dto)
        updateProvinceAssociation(districtEntity, dto)

        return toDTO(getRepository().save(districtEntity))
    }

    override fun delete(id: Long): DistrictDto {
        val entity = onDeleteValidate(id)
            .apply { province = null }
        getRepository().delete(entity)
        return toDTO(entity)
    }

    private fun updateDistrictFields(districtEntity: District, dto: DistrictDto) {
        districtEntity.apply {
            code = dto.code
            name = dto.name
        }
    }

    private fun updateProvinceAssociation(entity: District, dto: DistrictDto) {
        val newProvinceId = dto.province?.id
        val currentProvinceId = entity.province?.id

        when {
            newProvinceId == null && currentProvinceId != null -> entity.province = null

            newProvinceId != null && newProvinceId != currentProvinceId -> {
                entity.province =
                    provinceRepository.findById(newProvinceId).orElseThrow { BusinessException(MessageKey.BAD_REQUEST) }
            }
        }
    }
}