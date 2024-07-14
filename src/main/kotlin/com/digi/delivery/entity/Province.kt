package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name = "provinces")
class Province(
    @Column(name = "code", columnDefinition = "NVARCHAR(255) COLLATE LATIN1_GENERAL_100_CI_AS_SC_UTF8")
    var code: String? = null,

    @Column(name = "name", columnDefinition = "NVARCHAR(255) COLLATE LATIN1_GENERAL_100_CI_AS_SC_UTF8")
    var name: String? = null,

    @Column(name = "km")
    var km: Int? = 0,

    @Column(name = "license_plate_code", columnDefinition = "NVARCHAR(255) COLLATE LATIN1_GENERAL_100_CI_AS_SC_UTF8")
    var licensePlateCode: String? = null,

    @Column(name = "route_code", columnDefinition = "NVARCHAR(255) COLLATE LATIN1_GENERAL_100_CI_AS_SC_UTF8")
    var routeCode: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    var region: Region? = null,

    @OneToMany(
        cascade = [CascadeType.ALL],
        mappedBy = "province"
    )
    @Fetch(FetchMode.SUBSELECT)
    var districts: Set<District>? = emptySet(),
) : BaseEntity()