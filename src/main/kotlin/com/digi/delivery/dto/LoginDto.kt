package com.digi.delivery.dto

import com.digi.delivery.constant.MessageKey
import javax.validation.constraints.NotBlank

data class LoginDto(
    @NotBlank(message = MessageKey.VALIDATION_NOT_EMPTY)
    var username: String,

    @NotBlank(message = MessageKey.VALIDATION_NOT_EMPTY)
    var password: String,
)