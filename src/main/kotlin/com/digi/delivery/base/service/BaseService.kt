package com.digi.delivery.base.service

import com.digi.delivery.base.entity.BaseEntity
import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.dto.BaseDto
import org.springframework.data.domain.Page

interface BaseService<D : BaseDto, E : BaseEntity, S : BaseSearchCriteria<*>, R : BaseRepository<E, I>, I : Long> {

    fun findAll(): List<D>

    fun find(dto: D): D

    fun findById(id: I): D

    fun isExist(dto: D): Boolean

    fun add(dto: D): D

    fun update(dto: D): D

    fun addAll(dtos: List<D>): List<D>

    fun updateAll(dtos: List<D>): List<D>

    fun deleteAll(dtos: List<D>): List<D>

    fun search(searchCriteria: S): Page<D>

    fun delete(id: I): D
}
