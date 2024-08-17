package com.digi.delivery.controller

import com.digi.delivery.base.controller.BaseController
import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.dto.ReceiptDto
import com.digi.delivery.entity.Receipt
import com.digi.delivery.repository.ReceiptRepository
import com.digi.delivery.service.ReceiptService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${apiBasePath}/receipt")
@Api(tags = ["Receipt"], description = "Receipt")
class ReceiptController @Autowired constructor(
    receiptService: ReceiptService,
) : BaseController<ReceiptDto, Receipt, BaseSearchCriteria<String>, ReceiptService, ReceiptRepository, Long>(
    receiptService
)