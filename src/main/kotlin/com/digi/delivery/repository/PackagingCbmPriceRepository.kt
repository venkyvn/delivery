package com.digi.delivery.repository

import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.entity.PackagingCbmPrice
import org.springframework.stereotype.Repository

@Repository
interface PackagingCbmPriceRepository : BaseRepository<PackagingCbmPrice, Long> {
}