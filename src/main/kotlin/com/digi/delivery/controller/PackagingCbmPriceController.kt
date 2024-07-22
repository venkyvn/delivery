package com.digi.delivery.controller

import com.digi.delivery.base.controller.BaseController
import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.dto.PackagingCbmPriceDto
import com.digi.delivery.entity.PackagingCbmPrice
import com.digi.delivery.repository.PackagingCbmPriceRepository
import com.digi.delivery.service.PackagingCbmPriceService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${apiBasePath}/packaging-cbm-price")
@Api(tags = ["PackagingCbmPrice"], description = "PackagingCbmPrice")
class PackagingCbmPriceController @Autowired constructor(
    communeService: PackagingCbmPriceService,
) : BaseController<PackagingCbmPriceDto, PackagingCbmPrice, BaseSearchCriteria<String>, PackagingCbmPriceService, PackagingCbmPriceRepository, Long>(
    communeService
)
