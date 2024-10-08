package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "user_token")
class UserToken(
    @Column(name = "user_id")
    var userId: Long,

    @Column(name = "refresh_token", length = 500)
    var refreshToken: String,
) : BaseEntity()
