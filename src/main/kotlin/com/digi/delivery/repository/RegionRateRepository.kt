package com.digi.delivery.repository

import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.entity.RegionRate
import org.springframework.stereotype.Repository

@Repository
interface RegionRateRepository : BaseRepository<RegionRate, Long> {
}