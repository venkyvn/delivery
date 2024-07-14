package com.digi.delivery.base.entity

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.util.*
import javax.persistence.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = true)
    var createdDate: Date? = null

    @CreatedBy
    @Column(name = "created_by", columnDefinition = "NVARCHAR(255) COLLATE LATIN1_GENERAL_100_CI_AS_SC_UTF8", nullable = true)
    var createdBy: String? = null

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date", nullable = true)
    var updatedDate: Date? = null

    @LastModifiedBy
    @Column(name = "updated_by", columnDefinition = "NVARCHAR(255) COLLATE LATIN1_GENERAL_100_CI_AS_SC_UTF8", nullable = true)
    var updatedBy: String? = null

//    final override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        return id == (other as BaseEntity).id
//    }
//
//    final override fun hashCode(): Int = id.hashCode()

}