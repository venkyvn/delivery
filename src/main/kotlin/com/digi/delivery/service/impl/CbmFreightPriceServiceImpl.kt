package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.dto.CbmFreightPriceDto
import com.digi.delivery.entity.CbmFreightPrice
import com.digi.delivery.repository.CbmFreightPriceRepository
import com.digi.delivery.service.CbmFreightPriceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CbmFreightPriceServiceImpl @Autowired constructor(cbmFreightPrice: CbmFreightPriceRepository) :
    BaseServiceImpl<CbmFreightPriceDto, CbmFreightPrice, BaseSearchCriteria<String>, CbmFreightPriceRepository, Long>(
        cbmFreightPrice
    ),
    CbmFreightPriceService {

}