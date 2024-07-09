package com.digi.delivery.repository

import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.entity.District
import org.springframework.stereotype.Repository

@Repository
interface DistrictRepository : BaseRepository<District, Long> {
}