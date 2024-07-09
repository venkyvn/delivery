package com.digi.delivery.exception

import java.io.Serializable

data class ErrorInfo(
    var httpStatus: Int = 0,
    var messageKey: String? = null,
    var message: String? = null,
    var fieldError: List<FieldValidation>? = null
) : Serializable
