package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.dto.RegionRateDto
import com.digi.delivery.entity.RegionRate
import com.digi.delivery.repository.RegionRateRepository
import com.digi.delivery.service.RegionRateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class RegionRateServiceImpl @Autowired constructor(regionRate: RegionRateRepository) :
    BaseServiceImpl<RegionRateDto, RegionRate, BaseSearchCriteria<String>, RegionRateRepository, Long>(regionRate),
    RegionRateService {

}