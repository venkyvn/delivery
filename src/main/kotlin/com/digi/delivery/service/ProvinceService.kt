package com.digi.delivery.service

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.BaseService
import com.digi.delivery.dto.ProvinceDto
import com.digi.delivery.entity.Province
import com.digi.delivery.repository.ProvinceRepository

interface ProvinceService : BaseService<ProvinceDto, Province, BaseSearchCriteria<String>, ProvinceRepository, Long> {
}