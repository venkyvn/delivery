package com.digi.delivery.service

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.BaseService
import com.digi.delivery.dto.PackagingPriceDto
import com.digi.delivery.entity.PackagingPrice
import com.digi.delivery.repository.PackagingPriceRepository

interface PackagingPriceService : BaseService<PackagingPriceDto, PackagingPrice, BaseSearchCriteria<String>, PackagingPriceRepository, Long> {
}