package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.dto.PackagingPriceDto
import com.digi.delivery.entity.PackagingPrice
import com.digi.delivery.repository.PackagingPriceRepository
import com.digi.delivery.service.PackagingPriceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PackagingPriceServiceImpl @Autowired constructor(region: PackagingPriceRepository) :
    BaseServiceImpl<PackagingPriceDto, PackagingPrice, BaseSearchCriteria<String>, PackagingPriceRepository, Long>(
        region
    ),
    PackagingPriceService {

}