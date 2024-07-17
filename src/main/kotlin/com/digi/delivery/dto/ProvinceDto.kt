package com.digi.delivery.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

class ProvinceDto : BaseDto() {
    var code: String? = null
    var name: String? = null
    var km: Int? = 0
    var licensePlateCode: String? = null
    var routeCode: String? = null

    @JsonIgnoreProperties("provinces", "prices")
    var region: RegionDto? = null

    @JsonIgnoreProperties(value = ["province", "communes"])
    var districts: Set<DistrictDto>? = emptySet()
}
