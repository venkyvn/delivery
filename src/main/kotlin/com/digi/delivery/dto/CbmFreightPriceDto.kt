package com.digi.delivery.dto

data class CbmFreightPriceDto(
    var name: String? = null,
    var code: String? = null,
    var proposal: String? = null,
    var deliveryTime: Float? = null,
    var discount: Float? = null,
    var rate: Set<CbmRateDto>? = emptySet(),
) : BaseDto()