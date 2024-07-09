package com.digi.delivery.repository

import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.entity.UserToken
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserTokenRepo : BaseRepository<UserToken, Long> {
    fun findByRefreshToken(refreshToken: String): Optional<UserToken>

    fun deleteAllByRefreshToken(refreshToken: String)

    fun deleteAllByUserIdIn(ids: List<Long>)

}