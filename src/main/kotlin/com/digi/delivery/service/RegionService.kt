package com.digi.delivery.service

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.BaseService
import com.digi.delivery.dto.RegionDto
import com.digi.delivery.entity.Region
import com.digi.delivery.repository.RegionRepository

interface RegionService : BaseService<RegionDto, Region, BaseSearchCriteria<String>, RegionRepository, Long> {
}