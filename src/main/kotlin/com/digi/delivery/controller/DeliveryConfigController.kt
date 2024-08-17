package com.digi.delivery.controller

import com.digi.delivery.base.controller.BaseController
import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.dto.DeliveryConfigDto
import com.digi.delivery.entity.DeliveryConfig
import com.digi.delivery.repository.DeliveryConfigRepository
import com.digi.delivery.service.DeliveryConfigService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${apiBasePath}/delivery-config")
@Api(tags = ["DeliveryConfig"], description = "DeliveryConfig")
class DeliveryConfigController @Autowired constructor(
    deliveryConfigService: DeliveryConfigService,
) : BaseController<DeliveryConfigDto, DeliveryConfig, BaseSearchCriteria<String>, DeliveryConfigService, DeliveryConfigRepository, Long>(
    deliveryConfigService
)