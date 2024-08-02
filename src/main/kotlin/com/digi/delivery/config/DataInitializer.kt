package com.digi.delivery.config

import com.digi.delivery.constant.RoleConstant
import com.digi.delivery.dto.*
import com.digi.delivery.entity.Role
import com.digi.delivery.entity.User
import com.digi.delivery.repository.RoleRepository
import com.digi.delivery.repository.UserRepository
import com.digi.delivery.service.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class DataInitializer @Autowired constructor(
    var roleRepository: RoleRepository,
    var userRepository: UserRepository,
    var passwordEncoder: PasswordEncoder,
    var featureFlag: FeatureFlag,
//    var excelService: ExcelService,
    var regionService: RegionService,
    var regionFreightPriceService: RegionFreightPriceService,
    var provinceService: ProvinceService,
    var districtService: DistrictService,
    var communeService: CommuneService,
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        featureFlag.apply {
            initUser?.let { if (it) doInitUser() }
            initData?.let { if (it) doInitData() }
        }
    }

    private fun doInitData() {
        var eRegion = regionService.add(RegionDto().apply {
            code = "B1"
            name = "KHU VỰC MIỀN NAM"
        })

        val eProvince = provinceService.add(
            ProvinceDto().apply {
                code = "tinh A"
                licensePlateCode = "licensePlateCode"
                region = RegionDto().apply { id = eRegion.id }

            }
        )

//        val eRegionPrice = regionFreightPriceService.add(
//            RegionFreightPriceDto().apply {
//                name = "regionFreightPriceService 1"
//                region = RegionDto().apply { id = eRegion.id }
//                regionPrices = setOf(
//                    RegionRateDto().apply {
//                        fromKg = 1f
//                        toKg = 2f
//                        price = BigDecimal.ONE
//                    },
//                    RegionRateDto().apply {
//                        fromKg = 3f
//                        toKg = 4f
//                        price = BigDecimal.TEN
//                    },
//                )
//            }
//        )

        val eDistrict = districtService.add(
            DistrictDto().apply {
                code = "district code"
                name = "district name"
                province = ProvinceDto().apply { id = eProvince.id }

            }
        )

        val eCommune = communeService.add(
            CommuneDto().apply {
                code = "commune code"
                name = "commune name"
                district = DistrictDto().apply { id = eDistrict.id }
            }
        )

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
