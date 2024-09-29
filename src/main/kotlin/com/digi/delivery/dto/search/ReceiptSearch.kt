package com.digi.delivery.dto.search

import com.digi.delivery.entity.enumerate.BillStatusEnum
import com.digi.delivery.entity.enumerate.SettlementStatusEnum

class ReceiptSearch {
    val orderNumber: String? = null
    var receiptCode: String? = null
    val senderName: String? = null
    val senderIdCard: String? = null
    val senderPhone: String? = null
    val receiverName: String? = null
    val receiverIdCard: String? = null
    val receiverPhone: String? = null
    val billStatus: BillStatusEnum ?= null
    val settlementStatus: SettlementStatusEnum?= null
}