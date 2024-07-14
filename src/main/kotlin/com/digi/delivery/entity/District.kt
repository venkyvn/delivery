package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name = "districts")
class District(
    @Column(name = "code", columnDefinition = "NVARCHAR(255) COLLATE LATIN1_GENERAL_100_CI_AS_SC_UTF8")
    var code: String? = null,

    @Column(name = "name", columnDefinition = "NVARCHAR(255) COLLATE LATIN1_GENERAL_100_CI_AS_SC_UTF8")
    var name: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    var province: Province? = null,

    @OneToMany(
        cascade = [CascadeType.ALL],
        mappedBy = "district"
    )
    @Fetch(FetchMode.SUBSELECT)
    var communes: Set<Commune>? = emptySet(),
) : BaseEntity()
