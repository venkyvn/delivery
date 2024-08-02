package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "communes")
class Commune(
    @Column(name = "code", columnDefinition = "NVARCHAR(255)")
    var code: String? = null,

    @Column(name = "name", columnDefinition = "NVARCHAR(255)")
    var name: String? = null,

    @Column(name = "label", columnDefinition = "NVARCHAR(255)")
    var label: String? = null,

    @Column(name = "km", columnDefinition = "NVARCHAR(255)")
    var km: String? = null,

    @Column(name = "percent_rate", columnDefinition = "NVARCHAR(255)")
    var percentRate: String? = null,

    @Column(name = "shipment_type", columnDefinition = "NVARCHAR(255)")
    var shipmentType: String? = null,

    //v
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    var district: District? = null,

    ) : BaseEntity()
