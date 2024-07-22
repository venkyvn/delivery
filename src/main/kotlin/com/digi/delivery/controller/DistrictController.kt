package com.digi.delivery.controller

import com.digi.delivery.base.controller.BaseController
import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.dto.DistrictDto
import com.digi.delivery.entity.District
import com.digi.delivery.repository.DistrictRepository
import com.digi.delivery.service.DistrictService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${apiBasePath}/district")
@Api(tags = ["District"], description = "District")
class DistrictController @Autowired constructor(
    districtService: DistrictService,
) : BaseController<DistrictDto, District, BaseSearchCriteria<String>, DistrictService, DistrictRepository, Long>(
    districtService
)
