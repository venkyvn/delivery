package com.digi.delivery.config

import com.digi.delivery.util.SecurityUtils
import org.springframework.data.domain.AuditorAware
import java.util.*

class AuditorAwareImpl : AuditorAware<String> {
    override fun getCurrentAuditor(): Optional<String> {
        return SecurityUtils.getCurrentUser()
    }
}