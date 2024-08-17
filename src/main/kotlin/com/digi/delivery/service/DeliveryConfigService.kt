package com.digi.delivery.service

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.BaseService
import com.digi.delivery.dto.DeliveryConfigDto
import com.digi.delivery.entity.DeliveryConfig
import com.digi.delivery.repository.DeliveryConfigRepository

interface DeliveryConfigService : BaseService<DeliveryConfigDto, DeliveryConfig, BaseSearchCriteria<String>, DeliveryConfigRepository, Long> {
}