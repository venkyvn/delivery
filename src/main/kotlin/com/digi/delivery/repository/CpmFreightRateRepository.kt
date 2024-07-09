package com.digi.delivery.repository

import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.entity.CbmFreightPrice
import org.springframework.stereotype.Repository

@Repository
interface CpmFreightRateRepository : BaseRepository<CbmFreightPrice, Long> {
}