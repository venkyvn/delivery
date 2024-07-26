package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "packaging_prices")
class PackagingPrice(
    @Column(name = "code", columnDefinition = "NVARCHAR(255)")
    var code: String? = null,

    @Column(name = "name", columnDefinition = "NVARCHAR(255)")
    var name: String? = null,

    @Column(name = "label", columnDefinition = "NVARCHAR(255)")
    var label: String? = null,

    @Column(name = "size")
    var size: String? = null,

    @Column(name = "unit")
    var unit: String? = null,

    @Column(name = "price")
    var price: BigDecimal? = BigDecimal.ZERO,

    @Column(name = "reuse_price")
    var reusePrice: BigDecimal? = BigDecimal.ZERO,

    @Column(name = "v1_price")
    var v1Price: BigDecimal? = BigDecimal.ZERO,

    @Column(name = "labor_cost")
    var laborCost: BigDecimal? = BigDecimal.ZERO,

    @Column(name = "first_price")
    var firstPrice: BigDecimal? = BigDecimal.ZERO,

    @Column(name = "second_price")
    var secondPrice: BigDecimal? = BigDecimal.ZERO,

    @Column(name = "discount")
    var discount: Float? = null,

    @Column(name = "vat")
    var vat: Float? = null,

    @Column(name = "note")
    var note: String? = null,

    ) : BaseEntity()
