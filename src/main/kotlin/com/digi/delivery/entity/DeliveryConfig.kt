package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "delivery_config")
class DeliveryConfig : BaseEntity() {
    @Column(name = "tax", columnDefinition = "NVARCHAR(255)")
    var tax: String? = null
}