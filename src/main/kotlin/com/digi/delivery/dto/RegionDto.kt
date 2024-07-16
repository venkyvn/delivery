package com.digi.delivery.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

class RegionDto : BaseDto() {
    var code: String? = null
    var name: String? = null

    @JsonIgnoreProperties(value = ["region", "districts"])
    var provinces: Set<ProvinceDto>? = emptySet()

    @JsonIgnoreProperties(value = ["region", "rates"])
    var prices: Set<RegionFreightPriceDto>? = emptySet()

}