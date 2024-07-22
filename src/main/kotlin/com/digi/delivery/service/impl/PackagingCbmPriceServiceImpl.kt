package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.dto.PackagingCbmPriceDto
import com.digi.delivery.entity.PackagingCbmPrice
import com.digi.delivery.repository.PackagingCbmPriceRepository
import com.digi.delivery.service.PackagingCbmPriceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PackagingCbmPriceServiceImpl @Autowired constructor(region: PackagingCbmPriceRepository) :
    BaseServiceImpl<PackagingCbmPriceDto, PackagingCbmPrice, BaseSearchCriteria<String>, PackagingCbmPriceRepository, Long>(
        region
    ),
    PackagingCbmPriceService {

}