package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name = "regions")
class Region(
    @Column(name = "code", columnDefinition = "NVARCHAR(255) COLLATE LATIN1_GENERAL_100_CI_AS_SC_UTF8")
    var code: String? = null,

    @Column(name = "name", columnDefinition = "NVARCHAR(255) COLLATE LATIN1_GENERAL_100_CI_AS_SC_UTF8")
    var name: String? = null,

    @OneToMany(
        cascade = [CascadeType.ALL],
        mappedBy = "region"
    )
    @Fetch(FetchMode.SUBSELECT)
    var provinces: Set<Province>? = emptySet(),

    @OneToMany(
        cascade = [CascadeType.ALL],
        mappedBy = "region"
    )
    @Fetch(FetchMode.SUBSELECT)
    var prices: Set<RegionFreightPrice>? = emptySet(),
) : BaseEntity()