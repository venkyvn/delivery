package com.digi.delivery.dto

import java.math.BigDecimal

data class CbmRateDto(
    var fromVolume: Float? = null,
    var toVolume: Float? = null,
    var price: BigDecimal? = BigDecimal.ZERO,
    var additionalPrice: BigDecimal? = BigDecimal.ZERO,
) : BaseDto()