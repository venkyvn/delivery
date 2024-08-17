package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "receipt")
class Receipt : BaseEntity() {
    @Column(name = "sender_name", columnDefinition = "NVARCHAR(255)")
    var senderName: String? = null

    @Column(name = "sender_id_card", columnDefinition = "NVARCHAR(255)")
    var senderIdCard: String? = null

    @Column(name = "sender_phone", columnDefinition = "NVARCHAR(255)")
    var senderPhone: String? = null

    @Column(name = "sender_address", columnDefinition = "NVARCHAR(255)")
    var senderAddress: String? = null

    @Column(name = "receiver_name", columnDefinition = "NVARCHAR(255)")
    var receiverName: String? = null

    @Column(name = "receiver_id_card", columnDefinition = "NVARCHAR(255)")
    var receiverIdCard: String? = null

    @Column(name = "receiver_phone", columnDefinition = "NVARCHAR(255)")
    var receiverPhone: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_province_id")
    var receiverProvince: Province? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_district_id")
    var receiverDistrict: District? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_commune_id")
    var receiverCommune: Commune? = null

    @Column(name = "receiver_address", columnDefinition = "NVARCHAR(255)")
    var receiverAddress: String? = null

    @Column(name = "item_name", columnDefinition = "NVARCHAR(255)")
    var itemName: String? = null

    @Column(name = "item_value")
    var itemValue: BigDecimal = BigDecimal.ZERO

    @Column(name = "item_length")
    var itemLength: BigDecimal = BigDecimal.ZERO

    @Column(name = "item_width")
    var itemWidth: BigDecimal = BigDecimal.ZERO

    @Column(name = "item_height")
    var itemHeight: BigDecimal = BigDecimal.ZERO

    @Column(name = "item_weight")
    var itemWeight: BigDecimal = BigDecimal.ZERO

    @Column(name = "item_fragile")
    var itemFragile: Boolean = false

    @Column(name = "item_quantity")
    var itemQuantity: Int = 1

    @Column(name = "service_fee")
    var serviceFee: BigDecimal = BigDecimal.ZERO

    @Column(name = "packaging_service", columnDefinition = "NVARCHAR(255)")
    var packagingService: String? = null

    @Column(name = "packaging_service_fee")
    var packagingServiceFee: BigDecimal = BigDecimal.ZERO

    @Column(name = "packaging_service_quantity")
    var packagingServiceQuantity: Int = 1

    @Column(name = "total_amount")
    var totalAmount: BigDecimal = BigDecimal.ZERO
}