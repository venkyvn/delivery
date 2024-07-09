package com.digi.delivery.service

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.BaseService
import com.digi.delivery.dto.UserDto
import com.digi.delivery.entity.User
import com.digi.delivery.repository.UserRepository
import java.util.*

interface UserService : BaseService<UserDto, User, BaseSearchCriteria<String>, UserRepository, Long> {
    fun getCurrentUser(): Optional<User>
    fun getCurrentUserDto(): UserDto
}