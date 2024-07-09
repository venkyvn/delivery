package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.dto.RegionFreightPriceDto
import com.digi.delivery.entity.RegionFreightPrice
import com.digi.delivery.repository.RegionFreightPriceRepository
import com.digi.delivery.service.RegionFreightPriceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class RegionFreightPriceServiceImpl @Autowired constructor(regionFreightPriceRepository: RegionFreightPriceRepository) :
    BaseServiceImpl<RegionFreightPriceDto, RegionFreightPrice, BaseSearchCriteria<String>, RegionFreightPriceRepository, Long>(
        regionFreightPriceRepository
    ),
    RegionFreightPriceService {

}