package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "roles")
class Role(
    @Column(name = "name", unique = true, nullable = false)
    var name: String,

    @ManyToMany(mappedBy = "roles")
    var users: Set<User> = mutableSetOf(),
): BaseEntity()
