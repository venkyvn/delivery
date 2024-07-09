package com.digi.delivery.repository

import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.entity.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : BaseRepository<User, Long> {

    fun findByUsernameIgnoreCase(username: String): Optional<User>

    fun findFirstByUsernameIgnoreCaseOrEmailIgnoreCase(username: String, email: String): Optional<User>

}