package com.digi.delivery.dto

import com.digi.delivery.entity.CbmRate
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

class RegionFreightPriceDto() : BaseDto() {
    var name: String? = null
    var code: String? = null
    var label: String? = null
    var proposal: String? = null
    var deliveryTime: String? = null
    var discount: Float? = null

    @JsonIgnoreProperties("regionFreightPrice", "regionFreightPrice")
    var regionRates: Set<RegionRateDto>? = emptySet()

    @JsonIgnoreProperties("regionFreightPrice", "regionFreightPrice")
    var cbmRates: Set<CbmRateDto>? = emptySet()
}