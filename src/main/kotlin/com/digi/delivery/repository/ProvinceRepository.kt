package com.digi.delivery.repository

import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.dto.ProvinceLiteDto
import com.digi.delivery.entity.Province
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ProvinceRepository : BaseRepository<Province, Long> {

    @Query("SELECT new com.digi.delivery.dto.ProvinceLiteDto(s.id, s.code, s.name, s.km, s.licensePlateCode, s.routeCode) FROM Province s")
    fun findAllProvinceLite(): List<ProvinceLiteDto>
}