package com.digi.delivery.repository

import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.entity.AccessToken
import org.springframework.stereotype.Repository

@Repository
interface AccessTokenRepository : BaseRepository<AccessToken, Long> {
    fun existsByToken(token: String): Boolean
}