package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.dto.DistrictDto
import com.digi.delivery.entity.District
import com.digi.delivery.repository.DistrictRepository
import com.digi.delivery.service.DistrictService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class DistrictServiceImpl @Autowired constructor(districtRepository: DistrictRepository) :
    BaseServiceImpl<DistrictDto, District, BaseSearchCriteria<String>, DistrictRepository, Long>(districtRepository),
    DistrictService {

}