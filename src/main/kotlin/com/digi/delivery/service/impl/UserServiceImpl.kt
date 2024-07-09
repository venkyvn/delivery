package com.digi.delivery.service.impl

import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.base.service.impl.BaseServiceImpl
import com.digi.delivery.constant.MessageKey
import com.digi.delivery.dto.UserDto
import com.digi.delivery.entity.User
import com.digi.delivery.exception.BusinessException
import com.digi.delivery.repository.UserRepository
import com.digi.delivery.service.UserService
import com.digi.delivery.util.SecurityUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional(readOnly = true)
class UserServiceImpl @Autowired constructor(userRepository: UserRepository) :
    BaseServiceImpl<UserDto, User, BaseSearchCriteria<String>, UserRepository, Long>(userRepository), UserService {

    override fun getCurrentUser(): Optional<User> {
        return SecurityUtils.getCurrentUser().flatMap { this.getRepository().findByUsernameIgnoreCase(it) }
    }

    override fun getCurrentUserDto(): UserDto {
        val user = this.getCurrentUser().orElseThrow{BusinessException(MessageKey.NOT_FOUND)}
        return toDTO(user)
    }

}