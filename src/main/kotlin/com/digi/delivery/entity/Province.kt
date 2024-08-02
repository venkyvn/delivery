package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name = "provinces")
class Province : BaseEntity() {
    @Column(name = "code", columnDefinition = "NVARCHAR(255)")
    var code: String? = null

    @Column(name = "name", columnDefinition = "NVARCHAR(255)")
    var name: String? = null

    @Column(name = "km")
    var km: String? = null

    @Column(name = "license_plate_code", columnDefinition = "NVARCHAR(255)")
    var licensePlateCode: String? = null

    @Column(name = "route_code", columnDefinition = "NVARCHAR(255)")
    var routeCode: String? = null

    //v
    @ManyToOne
    @JoinColumn(name = "region_id")
    var region: Region? = null

//    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
//    @JoinColumn(name = "province_id", referencedColumnName = "id")
//    @Fetch(FetchMode.SUBSELECT)
//    var districts: Set<District> = emptySet()

    //v
    @ManyToOne
    @JoinColumn(name = "region_freight_price_id")
    var regionFreightPrice: RegionFreightPrice? = null
}