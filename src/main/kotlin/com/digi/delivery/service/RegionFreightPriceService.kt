package com.digi.delivery.service

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.BaseService
import com.digi.delivery.dto.RegionFreightPriceDto
import com.digi.delivery.entity.RegionFreightPrice
import com.digi.delivery.repository.RegionFreightPriceRepository

interface RegionFreightPriceService :
    BaseService<RegionFreightPriceDto, RegionFreightPrice, BaseSearchCriteria<String>, RegionFreightPriceRepository, Long> {
}