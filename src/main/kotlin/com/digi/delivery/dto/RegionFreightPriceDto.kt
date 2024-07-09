package com.digi.delivery.dto

data class RegionFreightPriceDto(
    var name: String? = null,
    var code: Float? = null,
    var proposal: String? = null,
    var deliveryTime: Float? = null,
    var discount: Float? = null,
    var rate: Set<RegionRateDto>? = emptySet(),
) : BaseDto()