package com.digi.delivery.service

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.BaseService
import com.digi.delivery.dto.CommuneDto
import com.digi.delivery.dto.CommuneLiteDto
import com.digi.delivery.entity.Commune
import com.digi.delivery.repository.CommuneRepository

interface CommuneService : BaseService<CommuneDto, Commune, BaseSearchCriteria<String>, CommuneRepository, Long> {
    fun getAllCommuneLite(): List<CommuneLiteDto>
}