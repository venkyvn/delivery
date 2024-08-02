package com.digi.delivery.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

class CommuneDto : BaseDto() {
    var code: String? = null
    var name: String? = null
    var label: String? = null
    var km: String? = null
    var shipmentType: String? = null
    var percentRate: String? = null

    @JsonIgnoreProperties("communes")
    var district: DistrictDto? = null
}