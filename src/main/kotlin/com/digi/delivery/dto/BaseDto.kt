package com.digi.delivery.dto

import java.io.Serializable

open class BaseDto : Serializable {
    var id: Long? = null
    final override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BaseDto

        return id == other.id
    }

    final override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}
