package com.digi.delivery.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigDecimal

class RegionRateDto : BaseDto() {
    var fromKg: Float? = null
    var toKg: Float? = null
    var price: BigDecimal? = BigDecimal.ZERO
    var additionalPrice: BigDecimal? = BigDecimal.ZERO
    var additionalWeight: BigDecimal? = BigDecimal.ZERO
    var note: String? = null

    @JsonIgnoreProperties("rates")
    var regionFreightPrice: RegionFreightPriceDto? = null

}