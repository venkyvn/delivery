package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name = "regions")
class Region : BaseEntity() {
    @Column(name = "code", columnDefinition = "NVARCHAR(255)")
    var code: String? = null

    @Column(name = "name", columnDefinition = "NVARCHAR(255)")
    var name: String? = null

    //v
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    @Fetch(FetchMode.SUBSELECT)
    var provinces: Set<Province> = emptySet()

    //v
    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "region")
    var regionFreightPrice: RegionFreightPrice ?= null

}