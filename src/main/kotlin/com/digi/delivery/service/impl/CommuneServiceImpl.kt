package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.dto.CommuneDto
import com.digi.delivery.entity.Commune
import com.digi.delivery.repository.CommuneRepository
import com.digi.delivery.service.CommuneService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CommuneServiceImpl @Autowired constructor(communeRepository: CommuneRepository) :
    BaseServiceImpl<CommuneDto, Commune, BaseSearchCriteria<String>, CommuneRepository, Long>(communeRepository),
    CommuneService {

}