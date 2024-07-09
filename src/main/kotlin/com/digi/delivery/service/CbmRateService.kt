package com.digi.delivery.service

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.BaseService
import com.digi.delivery.dto.CbmRateDto
import com.digi.delivery.entity.CbmRate
import com.digi.delivery.repository.CbmRateRepository

interface CbmRateService :
    BaseService<CbmRateDto, CbmRate, BaseSearchCriteria<String>, CbmRateRepository, Long> {
}