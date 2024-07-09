package com.digi.delivery.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import lombok.AllArgsConstructor

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
open class BaseAccount(
    var name: String? = null,
    var username: String? = null,
    var email: String? = null
) : BaseDto() // Assuming BaseDto is your superclass
