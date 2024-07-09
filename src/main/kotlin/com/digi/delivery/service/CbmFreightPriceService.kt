package com.digi.delivery.service

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.BaseService
import com.digi.delivery.dto.CbmFreightPriceDto
import com.digi.delivery.entity.CbmFreightPrice
import com.digi.delivery.repository.CbmFreightPriceRepository

interface CbmFreightPriceService : BaseService<CbmFreightPriceDto, CbmFreightPrice, BaseSearchCriteria<String>, CbmFreightPriceRepository, Long> {
}