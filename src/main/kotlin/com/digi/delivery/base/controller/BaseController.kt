package com.digi.delivery.base.controller

import com.digi.delivery.base.entity.BaseEntity
import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.BaseService
import com.digi.delivery.dto.BaseDto
import com.digi.delivery.dto.ResponseDto
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

abstract class BaseController<D : BaseDto, E : BaseEntity, S : BaseSearchCriteria<*>, SV : BaseService<D, E, S, R, ID>, R : BaseRepository<E, ID>, ID : Long>(
    private val service: SV,
) {

    @PostMapping("/search")
    fun search(@Validated @RequestBody searchFilter: S): ResponseEntity<ResponseDto> {
        return ResponseDto.ok(service.search(searchFilter))
    }

    @PostMapping("/search/all")
    fun searchAll(): ResponseEntity<ResponseDto> {
        return ResponseDto.ok(service.findAll())
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: ID): ResponseEntity<ResponseDto> {
        return ResponseDto.ok(service.findById(id))
    }

    @PostMapping
    fun add(@Validated @RequestBody dto: D): ResponseEntity<ResponseDto> {
        return ResponseDto.ok(service.add(dto))
    }

    @PutMapping
    fun update(@Validated @RequestBody dto: D): ResponseEntity<ResponseDto> {
        return ResponseDto.ok(service.update(dto))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: ID): ResponseEntity<ResponseDto> {
        return ResponseDto.ok(service.delete(id))
    }

    @DeleteMapping
    fun deleteList(@RequestBody bannerDtos: List<D>): ResponseEntity<ResponseDto> {
        return ResponseDto.ok(service.deleteAll(bannerDtos))
    }
}
