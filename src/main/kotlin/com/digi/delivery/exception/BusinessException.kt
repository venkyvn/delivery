package com.digi.delivery.exception

import lombok.ToString

@ToString
class BusinessException(override val message: String, vararg val args: Any?) : Exception()
