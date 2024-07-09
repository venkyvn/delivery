package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "high_value_shipping_prices")
class HighValueShippingPrice(
    @Column(name = "name", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var name: String? = null,

    @Column(name = "code", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var code: String? = null,

    @Column(name = "unit")
    var unit: Int? = null,

    @Embedded
    var price: Price? = null,

    ) : BaseEntity()
