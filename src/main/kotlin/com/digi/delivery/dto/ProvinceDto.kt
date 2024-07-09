package com.digi.delivery.dto

import com.digi.delivery.entity.District

data class ProvinceDto(
    var code: String? = null,
    var km: Int? = null,
    var licensePlateCode: String? = null,
    var routeCode: String? = null,
    var name: String? = null,
    var regionId: Long? = null,
    var districts: Set<DistrictDto>? = emptySet(),
) : BaseDto()
