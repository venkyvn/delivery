package com.digi.delivery.dto

import java.math.BigDecimal

class PackagingPriceDto : BaseDto() {
    var code: String? = null
    var name: String? = null
    var label: String? = null
    var price: BigDecimal? = BigDecimal.ZERO
    var reusePrice: BigDecimal? = BigDecimal.ZERO
    var v1Price: BigDecimal? = BigDecimal.ZERO
    var laborCost: BigDecimal? = BigDecimal.ZERO
    var firstPrice: BigDecimal? = BigDecimal.ZERO
    var secondPrice: BigDecimal? = BigDecimal.ZERO
    var discount: Float? = null
    var note: String? = null
}
