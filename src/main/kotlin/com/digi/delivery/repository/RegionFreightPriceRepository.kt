package com.digi.delivery.repository

import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.entity.RegionFreightPrice
import org.springframework.stereotype.Repository

@Repository
interface RegionFreightPriceRepository : BaseRepository<RegionFreightPrice, Long> {
}