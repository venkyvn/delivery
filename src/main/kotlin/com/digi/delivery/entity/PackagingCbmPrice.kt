package com.digi.delivery.entity

import com.digi.delivery.base.entity.BaseEntity
import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "packaging_cbm_prices")
class PackagingCbmPrice(
    @Column(name = "code", columnDefinition = "NVARCHAR(255) COLLATE LATIN1_GENERAL_100_CI_AS_SC_UTF8")
    var code: String? = null,

    @Column(name = "name", columnDefinition = "NVARCHAR(255) COLLATE LATIN1_GENERAL_100_CI_AS_SC_UTF8")
    var name: String? = null,

    @Column(name = "label", columnDefinition = "NVARCHAR(255) COLLATE LATIN1_GENERAL_100_CI_AS_SC_UTF8")
    var label: String? = null,

    @Column(name = "price")
    var price: BigDecimal? = BigDecimal.ZERO,

    @Column(name = "additional_weight_after_packing")
    var additionalWeightAfterPacking: Int? = null,
    
    @Column(name = "max_weight_per_package")
    var maxWeightPerPackage: Int? = null,

    @Column(name = "additional_price")
    var additionalPrice: BigDecimal? = BigDecimal.ZERO,

    ) : BaseEntity()
