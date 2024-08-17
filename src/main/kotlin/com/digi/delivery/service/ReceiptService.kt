package com.digi.delivery.service

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.BaseService
import com.digi.delivery.dto.ReceiptDto
import com.digi.delivery.entity.Receipt
import com.digi.delivery.repository.ReceiptRepository

interface ReceiptService : BaseService<ReceiptDto, Receipt, BaseSearchCriteria<String>, ReceiptRepository, Long> {
}