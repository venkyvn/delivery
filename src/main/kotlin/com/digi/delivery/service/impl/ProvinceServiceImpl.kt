package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.constant.MessageKey
import com.digi.delivery.dto.ProvinceDto
import com.digi.delivery.entity.Province
import com.digi.delivery.exception.BusinessException
import com.digi.delivery.repository.CbmFreightPriceRepository
import com.digi.delivery.repository.ProvinceRepository
import com.digi.delivery.repository.RegionFreightPriceRepository
import com.digi.delivery.repository.RegionRepository
import com.digi.delivery.service.ProvinceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ProvinceServiceImpl @Autowired constructor(
    val provinceRepository: ProvinceRepository,
    val regionRepository: RegionRepository,
    val regionFreightPriceRepository: RegionFreightPriceRepository,
    val cbmFreightPriceRepository: CbmFreightPriceRepository,
) :
    BaseServiceImpl<ProvinceDto, Province, BaseSearchCriteria<String>, ProvinceRepository, Long>(provinceRepository),
    ProvinceService {
    override fun update(dto: ProvinceDto): ProvinceDto {
        val dtoId = dto.id ?: throw BusinessException(MessageKey.BAD_REQUEST)
        val provinceEntity = getRepository().findById(dtoId).orElseThrow { BusinessException(MessageKey.BAD_REQUEST) }

        updateProvinceFields(provinceEntity, dto)
        updateRegionAssociation(provinceEntity, dto)
        updateRegionFreightPriceAssociation(provinceEntity, dto)
        updateCbmFreightPriceAssociation(provinceEntity, dto)

        return toDTO(provinceRepository.save(provinceEntity))
    }

    private fun updateCbmFreightPriceAssociation(entity: Province, dto: ProvinceDto) {
        val newCbmFreightId = dto.cbmFreightPrice?.id
        val currentCbmFreightId = entity.cbmFreightPrice?.id

        when {
            newCbmFreightId == null && currentCbmFreightId != null -> entity.cbmFreightPrice = null

            newCbmFreightId != null && newCbmFreightId != currentCbmFreightId -> {
                val cbmFreightPriceEntity =
                    cbmFreightPriceRepository.findById(newCbmFreightId)
                        .orElseThrow { BusinessException(MessageKey.BAD_REQUEST) }
                entity.cbmFreightPrice = cbmFreightPriceEntity
            }
        }
    }

    private fun updateRegionFreightPriceAssociation(entity: Province, dto: ProvinceDto) {
        val newRegionFreightId = dto.regionFreightPrice?.id
        val currentRegionFreightId = entity.regionFreightPrice?.id

        when {
            newRegionFreightId == null && currentRegionFreightId != null -> entity.regionFreightPrice = null

            newRegionFreightId != null && newRegionFreightId != currentRegionFreightId -> {
                val regionFreightPriceEntity =
                    regionFreightPriceRepository.findById(newRegionFreightId)
                        .orElseThrow { BusinessException(MessageKey.BAD_REQUEST) }
                entity.regionFreightPrice = regionFreightPriceEntity
            }
        }
    }

    private fun updateProvinceFields(provinceEntity: Province, dto: ProvinceDto) {
        provinceEntity.apply {
            code = dto.code
            name = dto.name
            km = dto.km
            licensePlateCode = dto.licensePlateCode
            routeCode = dto.routeCode
        }
    }

    private fun updateRegionAssociation(entity: Province, dto: ProvinceDto) {
        val newRegionId = dto.region?.id
        val currentRegionId = entity.region?.id

        when {
            newRegionId == null && currentRegionId != null -> entity.region = null

            newRegionId != null && newRegionId != currentRegionId -> {
                val regionEntity =
                    regionRepository.findById(newRegionId).orElseThrow { BusinessException(MessageKey.BAD_REQUEST) }
                entity.region = regionEntity

            }
        }
    }

    override fun delete(id: Long): ProvinceDto {
        val entity = onDeleteValidate(id)
            .apply {
                region = null
                regionFreightPrice = null
                cbmFreightPrice = null
            }
        getRepository().delete(entity)
        return toDTO(entity)
    }

    //    override fun update(dto: ProvinceDto): ProvinceDto {
//        val dtoID = dto.id ?: throw BusinessException(MessageKey.BAD_REQUEST)
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
