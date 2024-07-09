package com.digi.delivery.config

import com.digi.delivery.constant.RoleConstant
import com.digi.delivery.entity.Role
import com.digi.delivery.entity.User
import com.digi.delivery.repository.RoleRepository
import com.digi.delivery.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class DataInitializer : CommandLineRunner {
    @Autowired
    lateinit var roleRepository: RoleRepository

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    @Value("\${spring.flyway.enabled}")
    private var enableFlyWay: Boolean = false

    @Autowired
    lateinit var featureFlag: FeatureFlag

    override fun run(vararg args: String?) {
        featureFlag.apply {
          initUser?.let { if(it) doInitUser() }
          initData?.let { if(it) doInitData() }
        }
    }

    private fun doInitData() {

    }

    private fun doInitUser() {
        if (roleRepository.findByName(RoleConstant.ADMIN).isEmpty) {
            val adminRole = Role(name = RoleConstant.ADMIN)
            adminRole.createdBy = RoleConstant.ADMIN
            adminRole.updatedBy = RoleConstant.ADMIN
            roleRepository.save<Role>(adminRole)
        }

        if (roleRepository.findByName(RoleConstant.USER).isEmpty) {
            val userRole = Role(name = RoleConstant.USER)
            userRole.createdBy = RoleConstant.ADMIN
            userRole.updatedBy = RoleConstant.ADMIN
            roleRepository.save<Role>(userRole)
        }
        if (roleRepository.findByName(RoleConstant.ANONYMOUS).isEmpty) {
            val anonymousRole = Role(name = RoleConstant.ANONYMOUS)
            anonymousRole.createdBy = RoleConstant.ADMIN
            anonymousRole.updatedBy = RoleConstant.ADMIN
            roleRepository.save<Role>(anonymousRole)
        }

        if (!userRepository.findByUsernameIgnoreCase("admin").isPresent) {
            val adminUser = User(
                username = "admin",
                email = "admin@example.com",
            ).apply {
                password = passwordEncoder.encode("admin")
                createdBy = RoleConstant.ADMIN
                updatedBy = RoleConstant.ADMIN
                roles = mutableSetOf(roleRepository.findByName(RoleConstant.ADMIN).get())
            }
            userRepository.save(adminUser)
        }
    }
}
