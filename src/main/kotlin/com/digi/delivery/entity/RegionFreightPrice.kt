package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name = "region_freight_prices")
class RegionFreightPrice(
    @Column(name = "name", columnDefinition = "NVARCHAR(255)")
    var name: String? = null,

    @Column(name = "code", columnDefinition = "NVARCHAR(255)")
    var code: String? = null,

    @Column(name = "label", columnDefinition = "NVARCHAR(255)")
    var label: String? = null,

    @Column(name = "proposal", columnDefinition = "NVARCHAR(255)")
    var proposal: String? = null,

    @Column(name = "delivery_time")
    var deliveryTime: String? = null,

    @Column(name = "discount")
    var discount: Float? = null,

    //v
    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "region_freight_price_id", referencedColumnName = "id")
    @Fetch(FetchMode.SUBSELECT)
    var regionPrices: Set<RegionRate> = emptySet(),

    //v
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    var region: Region? = null,
) : BaseEntity()
