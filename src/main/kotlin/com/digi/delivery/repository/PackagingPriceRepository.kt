package com.digi.delivery.repository

import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.entity.PackagingPrice
import org.springframework.stereotype.Repository

@Repository
interface PackagingPriceRepository : BaseRepository<PackagingPrice, Long> {
}