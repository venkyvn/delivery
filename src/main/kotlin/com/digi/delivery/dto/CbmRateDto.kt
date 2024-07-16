package com.digi.delivery.dto

import java.math.BigDecimal

class CbmRateDto() : BaseDto() {
    var fromVolume: Float? = null
    var toVolume: Float? = null
    var price: BigDecimal? = BigDecimal.ZERO
    var additionalPrice: BigDecimal? = BigDecimal.ZERO
}