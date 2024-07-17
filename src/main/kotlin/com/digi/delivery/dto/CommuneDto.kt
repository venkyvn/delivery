package com.digi.delivery.dto

import com.digi.delivery.entity.ShipmentType
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

class CommuneDto : BaseDto() {
    var code: String? = null
    var name: String? = null

    @JsonIgnoreProperties("communes", "province")
    var district: DistrictDto? = null
    var shipmentType: ShipmentType? = null
}