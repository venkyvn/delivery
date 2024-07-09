package com.digi.delivery.dto

import com.fasterxml.jackson.annotation.JsonInclude
import java.io.Serializable
import javax.validation.constraints.NotBlank

@JsonInclude(JsonInclude.Include.NON_NULL)
data class JwtToken(
    var token: String? = null,

    @field:NotBlank(message = "Refresh token must not be empty!")
    var refreshToken: String
) : Serializable