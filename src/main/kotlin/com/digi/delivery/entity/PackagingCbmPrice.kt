package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "packaging_cbm_prices")
class PackagingCbmPrice(
    @Column(name = "code", columnDefinition = "NVARCHAR(255)")
    var code: String? = null,

    @Column(name = "name", columnDefinition = "NVARCHAR(255)")
    var name: String? = null,

    @Column(name = "label", columnDefinition = "NVARCHAR(255)")
    var label: String? = null,

    @Column(name = "price")
    var price: BigDecimal? = BigDecimal.ZERO,

    @Column(name = "additional_weight_after_packing")
    var additionalWeightAfterPacking: Float? = null,

    @Column(name = "max_weight_per_package")
    var maxWeightPerPackage: Float? = null,

    @Column(name = "additional_price")
    var additionalPrice: BigDecimal? = BigDecimal.ZERO,

    @Column(name ="from_cbm")
    var fromCbm: Float? = null,

    @Column(name ="to_cbm")
    var toCbm: Float? = null,

    @Column(name ="max_cbm")
    var maxCbm: Boolean? = false,

    @Column(name ="vat")
    var vat: Float? = null,

    @Column(name ="price_coefficient")
    var priceCoefficient: Float? = null,

    @Column(name ="note")
    var note: String? = null,

    ) : BaseEntity()
