package com.digi.delivery.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigDecimal

class ReceiptDto : BaseDto() {
    var senderName: String? = null

    var senderIdCard: String? = null

    var senderPhone: String? = null

    var senderAddress: String? = null

    var receiverName: String? = null

    var receiverIdCard: String? = null

    var receiverPhone: String? = null

    @JsonIgnoreProperties("region", "districts")
    var receiverProvince: ProvinceDto? = null

    @JsonIgnoreProperties("province", "communes")
    var receiverDistrict: DistrictDto? = null

    @JsonIgnoreProperties("district")
    var receiverCommune: CommuneDto? = null

    var receiverAddress: String? = null

    var itemName: String? = null

    var itemValue: BigDecimal = BigDecimal.ZERO

    var itemLength: BigDecimal = BigDecimal.ZERO

    var itemWidth: BigDecimal = BigDecimal.ZERO

    var itemHeight: BigDecimal = BigDecimal.ZERO

    var itemWeight: BigDecimal = BigDecimal.ZERO

    var itemFragile: Boolean = false

    var itemQuantity: Int = 1

    var serviceFee: BigDecimal = BigDecimal.ZERO

    var packagingService: String? = null

    var packagingServiceFee: BigDecimal = BigDecimal.ZERO

    var packagingServiceQuantity: Int = 1

    var totalAmount: BigDecimal = BigDecimal.ZERO
}
