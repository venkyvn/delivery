package com.digi.delivery.service

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.BaseService
import com.digi.delivery.dto.PackagingCbmPriceDto
import com.digi.delivery.entity.PackagingCbmPrice
import com.digi.delivery.repository.PackagingCbmPriceRepository

interface PackagingCbmPriceService : BaseService<PackagingCbmPriceDto, PackagingCbmPrice, BaseSearchCriteria<String>, PackagingCbmPriceRepository, Long> {
}