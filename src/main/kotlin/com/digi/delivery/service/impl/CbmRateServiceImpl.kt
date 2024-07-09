package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.dto.CbmRateDto
import com.digi.delivery.entity.CbmRate
import com.digi.delivery.repository.CbmRateRepository
import com.digi.delivery.service.CbmRateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CbmRateServiceImpl @Autowired constructor(cbmRate: CbmRateRepository) :
    BaseServiceImpl<CbmRateDto, CbmRate, BaseSearchCriteria<String>, CbmRateRepository, Long>(cbmRate),
    CbmRateService {

}