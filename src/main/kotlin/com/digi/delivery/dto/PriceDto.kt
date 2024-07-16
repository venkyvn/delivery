package com.digi.delivery.dto

import lombok.AllArgsConstructor

class PriceDto : BaseDto() {
    var priceName: String? = null
    var priceNumber: String? = null
    var priceCode: String? = null
    var minKG: Double? = null
    var maxKG: Double? = null
    var priceAdd: Boolean? = false
}
