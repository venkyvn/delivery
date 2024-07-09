package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.dto.ProvinceDto
import com.digi.delivery.entity.Province
import com.digi.delivery.repository.ProvinceRepository
import com.digi.delivery.service.ProvinceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ProvinceServiceImpl @Autowired constructor(packageRepository: ProvinceRepository) :
    BaseServiceImpl<ProvinceDto, Province, BaseSearchCriteria<String>, ProvinceRepository, Long>(packageRepository),
    ProvinceService {
//    override fun update(dto: ProvinceDto): ProvinceDto {
//        val dtoID = dto.id ?: throw throw BusinessException(MessageKey.BAD_REQUEST)
//        val entity = getRepository().findById(dtoID).orElseThrow { BusinessException(MessageKey.BAD_REQUEST) }
//        entity.apply {
//            label = dto.label
//            value = dto.value
//            licenseplates = dto.licenseplates
//            updateTransportationRoute(dto.transportationRoutes.orEmpty())
//        }
//
//        return toDTO(this.getRepository().save(entity))
//    }
}

//private fun Province.updateTransportationRoute(routesDto: Set<TransportationRouteDto>) {
//    val existingRoutes = this.transportationRoutes.toMutableSet()
//    existingRoutes.removeIf { route -> routesDto.none { it.id == route.id } }
//
//    routesDto.forEach { dto ->
//        existingRoutes.firstOrNull { it.id == dto.id }?.run {
//            label = dto.label
//            distanceName = dto.distanceName
//            transportationRouteCode = dto.transportationRouteCode
//            value = dto.value
//        } ?: also {
//            val newRoute = TransportationRoute().apply {
//                label = dto.label
//                distanceName = dto.distanceName
//                transportationRouteCode = dto.transportationRouteCode
//                value = dto.value
//            }
//            existingRoutes.add(newRoute)
//        }
//    }
//    transportationRoutes = existingRoutes
//}
//
