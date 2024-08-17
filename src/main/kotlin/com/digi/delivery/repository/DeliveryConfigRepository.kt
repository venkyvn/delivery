package com.digi.delivery.repository

import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.entity.DeliveryConfig
import com.digi.delivery.entity.Receipt
import com.digi.delivery.entity.RegionFreightPrice
import org.springframework.stereotype.Repository

@Repository
interface DeliveryConfigRepository : BaseRepository<DeliveryConfig, Long>