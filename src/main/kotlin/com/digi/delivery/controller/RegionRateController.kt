package com.digi.delivery.controller

import com.digi.delivery.base.controller.BaseController
import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.dto.RegionRateDto
import com.digi.delivery.entity.RegionRate
import com.digi.delivery.repository.RegionRateRepository
import com.digi.delivery.service.RegionRateService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${apiBasePath}/region-rate")
@Api(tags = ["RegionRate"], description = "RegionRate")
class RegionRateController @Autowired constructor(
    regionRateService: RegionRateService,
) : BaseController<RegionRateDto, RegionRate, BaseSearchCriteria<String>, RegionRateService, RegionRateRepository, Long>(
    regionRateService
) {


}
