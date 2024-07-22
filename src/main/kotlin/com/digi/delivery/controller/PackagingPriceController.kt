package com.digi.delivery.controller

import com.digi.delivery.base.controller.BaseController
import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.dto.PackagingPriceDto
import com.digi.delivery.entity.PackagingPrice
import com.digi.delivery.repository.PackagingPriceRepository
import com.digi.delivery.service.PackagingPriceService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${apiBasePath}/packaging-price")
@Api(tags = ["PackagingPrice"], description = "PackagingPrice")
class PackagingPriceController @Autowired constructor(
    communeService: PackagingPriceService,
) : BaseController<PackagingPriceDto, PackagingPrice, BaseSearchCriteria<String>, PackagingPriceService, PackagingPriceRepository, Long>(
    communeService
)
