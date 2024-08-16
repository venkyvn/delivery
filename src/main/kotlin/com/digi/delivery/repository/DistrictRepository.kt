package com.digi.delivery.repository

import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.dto.DistrictLiteDto
import com.digi.delivery.entity.District
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface DistrictRepository : BaseRepository<District, Long> {
    @Query("SELECT new com.digi.delivery.dto.DistrictLiteDto(s.id, s.code, s.name) FROM District s")
    fun findAllDistrictLite(): List<DistrictLiteDto>

    @Query("SELECT new com.digi.delivery.dto.DistrictLiteDto(s.id, s.code, s.name) FROM District s where s.province.id = ?1")
    fun findAllDistrictLiteByProvinceId(provinceId: Long): List<DistrictLiteDto>
}