package com.digi.delivery.dto

data class CommuneDto(
    var code: String? = null,
    var name: String? = null,
    var districtId: Long? = null,
    var cbmFreightPrice: CbmFreightPriceDto? = null,
    var regionFreightPrice: RegionFreightPriceDto? = null,
) : BaseDto()