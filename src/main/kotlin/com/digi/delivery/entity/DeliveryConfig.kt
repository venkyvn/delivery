package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "delivery_config")
class DeliveryConfig : BaseEntity() {
    @Column(name = "code", columnDefinition = "NVARCHAR(255)")
    var code: String? = null
    @Column(name = "name", columnDefinition = "NVARCHAR(255)")
    var name: String? = null
    @Column(name = "note", columnDefinition = "NVARCHAR(255)")
    var note: String? = null
    @Column(name = "percentage", columnDefinition = "NVARCHAR(255)")
    var percentage: String? = null
}