package com.digi.delivery.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigDecimal

class CbmRateDto() : BaseDto() {
    var fromVolume: Float? = null
    var toVolume: Float? = null
    var additionalVolume: Float? = null
    var price: BigDecimal? = BigDecimal.ZERO
    var additionalPrice: BigDecimal? = BigDecimal.ZERO
    var note: String? = null

    @JsonIgnoreProperties("regionRates", "cbmRates")
    var regionFreightPrice: RegionFreightPriceDto? = null
}