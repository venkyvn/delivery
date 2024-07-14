package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "region_rates")
class RegionRate(
    @Column(name = "from_kg")
    var fromKg: Float? = null,

    @Column(name = "to_kg")
    var toKg: Float? = null,

    @Column(name = "price")
    var price: BigDecimal? = BigDecimal.ZERO,

    @Column(name = "additional_price")
    var additionalPrice: BigDecimal? = BigDecimal.ZERO,

    @Column(name = "additional_weight")
    var additionalWeight: BigDecimal? = BigDecimal.ZERO,

    @Column(name = "note")
    var note: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_freight_price_id")
    var regionFreightPrice: RegionFreightPrice? = null,


    ) : BaseEntity()
