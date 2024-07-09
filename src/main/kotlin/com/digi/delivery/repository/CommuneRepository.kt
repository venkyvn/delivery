package com.digi.delivery.repository

import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.entity.Commune
import org.springframework.stereotype.Repository

@Repository
interface CommuneRepository : BaseRepository<Commune, Long> {
}