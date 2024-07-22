package com.digi.delivery.controller

import com.digi.delivery.base.controller.BaseController
import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.dto.RegionFreightPriceDto
import com.digi.delivery.entity.RegionFreightPrice
import com.digi.delivery.repository.RegionFreightPriceRepository
import com.digi.delivery.service.RegionFreightPriceService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${apiBasePath}/region-price")
@Api(tags = ["RegionFreightPrice"], description = "RegionFreightPrice")
class RegionFreightPriceController @Autowired constructor(
    regionFreightPriceService: RegionFreightPriceService,
) : BaseController<RegionFreightPriceDto, RegionFreightPrice, BaseSearchCriteria<String>, RegionFreightPriceService, RegionFreightPriceRepository, Long>(
    regionFreightPriceService
)
