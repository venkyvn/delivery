package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "cbm_rates")
class CbmRate(
    @Column(name = "from_volume")
    var fromVolume: Float? = null,

    @Column(name = "to_volume")
    var toVolume: Float? = null,

    @Column(name = "additional_volume")
    var additionalVolume: Float? = null,

    @Column(name = "price")
    var price: BigDecimal? = BigDecimal.ZERO,

    @Column(name = "additional_price")
    var additionalPrice: BigDecimal? = BigDecimal.ZERO,

    @Column(name = "note")
    var note: String? = null,

    ) : BaseEntity()
