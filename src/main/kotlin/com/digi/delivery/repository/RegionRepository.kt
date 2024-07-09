package com.digi.delivery.repository

import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.entity.Region
import org.springframework.stereotype.Repository

@Repository
interface RegionRepository : BaseRepository<Region, Long> {
}