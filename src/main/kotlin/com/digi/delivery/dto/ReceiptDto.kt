package com.digi.delivery.dto

import com.digi.delivery.entity.PackagingServiceDto
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigDecimal
import java.util.*

class ReceiptDto : BaseDto() {
    var orderNumber: String? = null

    var receiptCode: String? = null

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

    var packagingServices: List<PackagingServiceDto>? = emptyList()

    var packagingServiceFee: BigDecimal = BigDecimal.ZERO

    var packagingServiceQuantity: Int = 1

    var totalAmount: BigDecimal = BigDecimal.ZERO

    var createdDate: Date? = null
}
