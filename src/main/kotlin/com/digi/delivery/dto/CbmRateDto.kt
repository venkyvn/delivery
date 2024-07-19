package com.digi.delivery.dto

import java.math.BigDecimal

class CbmRateDto() : BaseDto() {
    var fromVolume: Float? = null
    var toVolume: Float? = null
    var additionalVolume: Float? = null
    var price: BigDecimal? = BigDecimal.ZERO
    var additionalPrice: BigDecimal? = BigDecimal.ZERO
    var note: String? = null
    var cbmFreightPrice: CbmFreightPriceDto? = null
}