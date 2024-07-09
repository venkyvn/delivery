package com.digi.delivery.dto

import java.math.BigDecimal

data class RegionRateDto(
    var fromKg: String? = null,
    var toKg: Float? = null,
    var price: BigDecimal? = BigDecimal.ZERO,
    var additionalPrice: BigDecimal? = BigDecimal.ZERO,
) : BaseDto()