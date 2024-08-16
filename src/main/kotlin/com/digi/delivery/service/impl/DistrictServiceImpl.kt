package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.constant.MessageKey
import com.digi.delivery.dto.DistrictDto
import com.digi.delivery.dto.DistrictLiteDto
import com.digi.delivery.dto.search.BaseSearch
import com.digi.delivery.entity.District
import com.digi.delivery.exception.BusinessException
import com.digi.delivery.repository.DistrictRepository
import com.digi.delivery.repository.ProvinceRepository
import com.digi.delivery.repository.spec.BaseSpec
import com.digi.delivery.service.DistrictService
import com.digi.delivery.util.SearchHelper
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.commons.lang3.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class DistrictServiceImpl @Autowired constructor(
    districtRepository: DistrictRepository,
    val provinceRepository: ProvinceRepository,
) :
    BaseServiceImpl<DistrictDto, District, BaseSearchCriteria<BaseSearch>, DistrictRepository, Long>(districtRepository),
    DistrictService {
    override fun search(searchFilter: BaseSearchCriteria<BaseSearch>): Page<DistrictDto> {
        logger.info("search {}", searchFilter)
        val pageable = SearchHelper.getPageableObj(searchFilter)
        var spec: Specification<District> = Specification.where(null)
        val objectMapper = ObjectMapper()
        val baseSearch = objectMapper.convertValue(searchFilter.searchCriteria, BaseSearch::class.java)

        baseSearch?.let {
            if (!StringUtils.isBlank(baseSearch.code)) {
                spec = spec.and(BaseSpec<District>().hasCode(baseSearch.code!!))
            }
            if (!StringUtils.isBlank(baseSearch.name)) {
                spec = spec.and(BaseSpec<District>().hasName(baseSearch.name!!))
            }
        }

        val page = this.getRepository().findAll(spec, pageable)
        return PageImpl(toDTOs(page.content), pageable, page.totalElements)
    }

    override fun findDistrictByProvinceId(provinceId: Long): List<DistrictLiteDto> {
        return this.getRepository().findAllDistrictLiteByProvinceId(provinceId)
    }

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