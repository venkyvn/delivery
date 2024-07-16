package com.digi.delivery.dto

import com.digi.delivery.constant.MessageKey
import com.digi.delivery.constant.ValidatorConstant
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import lombok.AllArgsConstructor
import java.util.*
import javax.validation.constraints.Size

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
class AccountDto(
    private var password: @Size(
        min = ValidatorConstant.PASSWORD_MIN_LENGTH,
        max = ValidatorConstant.PASSWORD_MAX_LENGTH,
        message = MessageKey.VALIDATION_MAX_LENGTH
    ) String? = null,
): BaseDto()