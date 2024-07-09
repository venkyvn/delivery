package com.digi.delivery.repository

import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.entity.CbmRate
import org.springframework.stereotype.Repository

@Repository
interface CbmRateRepository : BaseRepository<CbmRate, Long> {
}