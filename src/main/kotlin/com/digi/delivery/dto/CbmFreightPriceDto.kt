package com.digi.delivery.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import lombok.AllArgsConstructor

@AllArgsConstructor
class CbmFreightPriceDto : BaseDto() {
    var name: String? = null
    var label: String? = null
    var code: String? = null
    var proposal: String? = null
    var deliveryTime: String? = null
    var discount: Float? = null

    @JsonIgnoreProperties("cbmFreightPrice")
    var cbmRates: Set<CbmRateDto>? = emptySet()
}