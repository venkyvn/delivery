package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.dto.RegionDto
import com.digi.delivery.entity.Region
import com.digi.delivery.repository.RegionRepository
import com.digi.delivery.service.RegionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class RegionServiceImpl @Autowired constructor(region: RegionRepository) :
    BaseServiceImpl<RegionDto, Region, BaseSearchCriteria<String>, RegionRepository, Long>(
        region
    ),
    RegionService {

}