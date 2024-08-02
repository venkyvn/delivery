package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name = "districts")
class District(
    @Column(name = "code", columnDefinition = "NVARCHAR(255)")
    var code: String? = null,

    @Column(name = "name", columnDefinition = "NVARCHAR(255)")
    var name: String? = null,

    //v
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    var province: Province? = null,

//    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
//    @JoinColumn(name = "district_id", referencedColumnName = "id")
//    @Fetch(FetchMode.SUBSELECT)
//    var communes: Set<Commune> = emptySet(),
) : BaseEntity()
