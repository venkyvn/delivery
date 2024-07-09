package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "over_sized_price")
class OverSizedPrice(
    @Column(name = "length", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var length: String? = null,

    @Column(name = "width", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var width: String? = null,

    @Column(name = "height", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var height: String? = null,

    @Column(name = "actual_weight", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var actualWeight: String? = null,

    @Column(name = "quantity", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var quantity: String? = null,

    @Column(name = "invoicing", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var invoicing: String? = null,

    @Embedded
    var price: Price? = null,

    ) : BaseEntity()
