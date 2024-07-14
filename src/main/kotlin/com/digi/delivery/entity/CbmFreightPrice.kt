package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name = "cbm_freight_prices")
class CbmFreightPrice(
    @Column(name = "name", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var name: String? = null,

    @Column(name = "code", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var code: String? = null,

    @Column(name = "proposal", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var proposal: String? = null,

    @Column(name = "delivery_time")
    var deliveryTime: Float? = null,

    @Column(name = "discount")
    var discount: Float? = null,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "cbm_freight_price_id")
    @Fetch(FetchMode.SUBSELECT)
    var rates: Set<CbmRate>? = emptySet(),

    ) : BaseEntity()
