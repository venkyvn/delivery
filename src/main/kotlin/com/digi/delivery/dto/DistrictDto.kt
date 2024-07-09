package com.digi.delivery.dto

data class DistrictDto(
    var code: String? = null,
    var name: String? = null,
    var provinceId: Long? = null,
    var communes: Set<CommuneDto>? = emptySet(),
    ) : BaseDto()