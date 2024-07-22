package com.digi.delivery.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

class DistrictDto : BaseDto() {
    var code: String? = null
    var name: String? = null

    @JsonIgnoreProperties("districts", "region", "regionFreightPrice")
    var province: ProvinceDto? = null

    @JsonIgnoreProperties(value = ["district"])
    var communes: Set<CommuneDto>? = emptySet()
}