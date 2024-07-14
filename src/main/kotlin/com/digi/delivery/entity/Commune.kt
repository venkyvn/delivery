package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "communes")
class Commune(
    @Column(name = "code", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var code: String? = null,

    @Column(name = "name", columnDefinition = "NVARCHAR(255) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    var name: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    var district: District? = null,

    @Enumerated(EnumType.STRING)
    var shipmentType: ShipmentType? = ShipmentType.IN_PROVINCE,

    ) : BaseEntity()
