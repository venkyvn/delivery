package com.digi.delivery.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "feature-flag")
class FeatureFlag {
    var initUser: Boolean? = false
    var initData: Boolean? = false
}