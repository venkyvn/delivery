package com.digi.delivery.repository

import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.dto.CommuneLiteDto
import com.digi.delivery.entity.Commune
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CommuneRepository : BaseRepository<Commune, Long> {
    @Query("SELECT new com.digi.delivery.dto.CommuneLiteDto(s.id, s.code, s.name, s.label, s.km, s.shipmentType, s.percentRate) FROM Commune s")
    fun findAllCommuneLite(): List<CommuneLiteDto>

    @Query("SELECT new com.digi.delivery.dto.CommuneLiteDto(s.id, s.code, s.name, s.label, s.km, s.shipmentType, s.percentRate) FROM Commune s where s.district.id = ?1")
    fun findAllCommuneLiteByDistrictId(districtId: Long): List<CommuneLiteDto>
}