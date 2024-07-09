package com.digi.delivery.exception

import javax.naming.AuthenticationException


data class UnauthorizedException(override var message: String?) : AuthenticationException(message)

