package com.digi.delivery.dto

import java.math.BigDecimal

class PackagingCbmPriceDto : BaseDto() {
    var code: String? = null
    var name: String? = null
    var label: String? = null
    var price: BigDecimal? = BigDecimal.ZERO
    var additionalWeightAfterPacking: Float? = null
    var maxWeightPerPackage: Float? = null
    var additionalPrice: BigDecimal? = BigDecimal.ZERO
}
