package com.digi.delivery.controller

import com.digi.delivery.base.controller.BaseController
import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.dto.RegionDto
import com.digi.delivery.entity.Region
import com.digi.delivery.repository.RegionRepository
import com.digi.delivery.service.RegionService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${apiBasePath}/region")
@Api(tags = ["Region"], description = "Region")
class RegionController @Autowired constructor(
    regionService: RegionService,
) : BaseController<RegionDto, Region, BaseSearchCriteria<String>, RegionService, RegionRepository, Long>(
    regionService
)