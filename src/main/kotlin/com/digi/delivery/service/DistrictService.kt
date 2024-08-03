package com.digi.delivery.service

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.BaseService
import com.digi.delivery.dto.DistrictDto
import com.digi.delivery.dto.DistrictLiteDto
import com.digi.delivery.entity.District
import com.digi.delivery.repository.DistrictRepository

interface DistrictService : BaseService<DistrictDto, District, BaseSearchCriteria<String>, DistrictRepository, Long> {
    fun getAllDistrictLite(): List<DistrictLiteDto>
}