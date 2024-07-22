package com.digi.delivery.controller

import com.digi.delivery.base.controller.BaseController
import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.dto.CbmRateDto
import com.digi.delivery.entity.CbmRate
import com.digi.delivery.repository.CbmRateRepository
import com.digi.delivery.service.CbmRateService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${apiBasePath}/cbm-rate")
@Api(tags = ["CbmRate"], description = "CbmRate")
class CbmRateController @Autowired constructor(
    cbmRateService: CbmRateService,
) : BaseController<CbmRateDto, CbmRate, BaseSearchCriteria<String>, CbmRateService, CbmRateRepository, Long>(
    cbmRateService
)
