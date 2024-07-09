package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "packaging_prices")
class PackagingPrice(
    @Column(name = "label", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var label: String? = null,

    @Column(name = "packaging_name", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var packagingName: String? = null,

    @Column(name = "unit")
    var unit: Int? = null,

    @Column(name = "value", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var value: String? = null,

    @Embedded
    var price: Price? = null,

    ) : BaseEntity()
