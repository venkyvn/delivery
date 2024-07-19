package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name = "cbm_freight_prices")
class CbmFreightPrice(
    @Column(name = "name", columnDefinition = "NVARCHAR(255)")
    var name: String? = null,

    @Column(name = "label", columnDefinition = "NVARCHAR(255)")
    var label: String? = null,

    @Column(name = "code", columnDefinition = "NVARCHAR(255)")
    var code: String? = null,

    @Column(name = "proposal", columnDefinition = "NVARCHAR(255)")
    var proposal: String? = null,

    @Column(name = "delivery_time")
    var deliveryTime: String? = null,

    @Column(name = "discount")
    var discount: Float? = null,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "cbm_freight_price_id", referencedColumnName = "id")
    @Fetch(FetchMode.SUBSELECT)
    var cbmRates: Set<CbmRate>? = emptySet(),

    ) : BaseEntity()
