package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name = "regions")
class Region(
    @Column(name = "name", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var name: String? = null,

    @Column(name = "code", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var code: String? = null,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    @Fetch(FetchMode.SUBSELECT)
    var provinces: Set<Province>? = emptySet(),
) : BaseEntity()