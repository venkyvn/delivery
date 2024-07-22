package com.digi.delivery.controller

import com.digi.delivery.base.controller.BaseController
import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.dto.CbmFreightPriceDto
import com.digi.delivery.entity.CbmFreightPrice
import com.digi.delivery.repository.CbmFreightPriceRepository
import com.digi.delivery.service.CbmFreightPriceService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${apiBasePath}/cbm-price")
@Api(tags = ["CbmFreightPrice"], description = "CbmFreightPrice")
class CbmFreightPriceController @Autowired constructor(
    cbmFreightPriceService: CbmFreightPriceService,
) : BaseController<CbmFreightPriceDto, CbmFreightPrice, BaseSearchCriteria<String>, CbmFreightPriceService, CbmFreightPriceRepository, Long>(
    cbmFreightPriceService
)
