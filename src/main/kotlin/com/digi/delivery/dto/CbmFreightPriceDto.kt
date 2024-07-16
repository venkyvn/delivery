package com.digi.delivery.dto

import lombok.AllArgsConstructor

@AllArgsConstructor
class CbmFreightPriceDto : BaseDto() {
    var name: String? = null
    var code: String? = null
    var proposal: String? = null
    var deliveryTime: Float? = null
    var discount: Float? = null
    var rate: Set<CbmRateDto>? = emptySet()
}