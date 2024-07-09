package com.digi.delivery.dto

import java.io.Serializable

abstract class BaseDto : Serializable {
    var id: Long? = null

//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
//    var updatedDate: Date? = null

}
