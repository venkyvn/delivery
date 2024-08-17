package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.dto.DeliveryConfigDto
import com.digi.delivery.entity.DeliveryConfig
import com.digi.delivery.repository.DeliveryConfigRepository
import com.digi.delivery.service.DeliveryConfigService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class DeliveryConfigServiceImpl @Autowired constructor(
    deliveryConfigRepository: DeliveryConfigRepository,
) :
    BaseServiceImpl<DeliveryConfigDto, DeliveryConfig, BaseSearchCriteria<String>, DeliveryConfigRepository, Long>(
        deliveryConfigRepository
    ),
    DeliveryConfigService {

}