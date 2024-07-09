package com.digi.delivery.service

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.BaseService
import com.digi.delivery.dto.RegionRateDto
import com.digi.delivery.entity.RegionRate
import com.digi.delivery.repository.RegionRateRepository

interface RegionRateService :
    BaseService<RegionRateDto, RegionRate, BaseSearchCriteria<String>, RegionRateRepository, Long> {
}