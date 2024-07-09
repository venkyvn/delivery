package com.digi.delivery.repository

import com.digi.delivery.base.repository.BaseRepository
import com.digi.delivery.entity.Role
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RoleRepository : BaseRepository<Role, Long> {
    fun findByName(role: String): Optional<Role>
}