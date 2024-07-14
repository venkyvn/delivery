package com.digi.delivery.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

class RegionFreightPriceDto() : BaseDto() {
    var name: String? = null
    var code: String? = null
    var label: String? = null
    var proposal: String? = null
    var deliveryTime: Float? = null
    var discount: Float? = null

    @JsonIgnoreProperties("regionFreightPrice")
    var rates: Set<RegionRateDto>? = emptySet()

    @JsonIgnoreProperties(value = ["prices", "provinces"])
    var region: RegionDto? = null

}