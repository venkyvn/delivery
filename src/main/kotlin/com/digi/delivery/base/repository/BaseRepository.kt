package com.digi.delivery.base.repository

import com.digi.delivery.base.entity.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface BaseRepository<E : BaseEntity, I: Long> : JpaRepository<E, I>, JpaSpecificationExecutor<E>