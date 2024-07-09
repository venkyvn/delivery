package com.digi.delivery.dto

data class RegionDto(
    var code: String? = null,
    var name: String? = null,
    var provinces: Set<ProvinceDto>? = emptySet(),
) : BaseDto()