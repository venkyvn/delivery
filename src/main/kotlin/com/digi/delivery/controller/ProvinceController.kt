package com.digi.delivery.controller

import com.digi.delivery.base.controller.BaseController
import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.dto.ProvinceDto
import com.digi.delivery.dto.ResponseDto
import com.digi.delivery.entity.Province
import com.digi.delivery.repository.ProvinceRepository
import com.digi.delivery.service.ProvinceService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${apiBasePath}/province")
@Api(tags = ["Province"], description = "Province")
class ProvinceController @Autowired constructor(
    val provinceService: ProvinceService,
) : BaseController<ProvinceDto, Province, BaseSearchCriteria<String>, ProvinceService, ProvinceRepository, Long>(
    provinceService
) {
    @GetMapping("/lite")
    fun getProvinceLite(): ResponseEntity<ResponseDto> {
        return ResponseDto.ok(provinceService.findAllProvinceLite())
    }

}
