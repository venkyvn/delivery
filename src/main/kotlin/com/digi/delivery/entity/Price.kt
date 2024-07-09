package com.digi.delivery.entity

import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
open class Price(
    @Column(name = "price_name", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var priceName: String? = null,

    @Column(name = "price_code", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var priceCode: String? = null,

    @Column(name = "price")
    var price: BigDecimal? = BigDecimal.ZERO,

    @Column(name = "min_kg")
    var minKG: Double? = null,

    @Column(name = "max_kg")
    var maxKG: Double? = null,

    @Column(name = "discount")
    var discount: Double? = null,

    )

