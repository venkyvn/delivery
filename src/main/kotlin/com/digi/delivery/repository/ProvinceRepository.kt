package com.digi.delivery.repository

import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.entity.Province
import org.springframework.stereotype.Repository

@Repository
interface ProvinceRepository : BaseRepository<Province, Long> {
}