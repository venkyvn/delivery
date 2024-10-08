package com.digi.delivery.controller

import com.digi.delivery.base.controller.BaseController
import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.dto.DistrictDto
import com.digi.delivery.dto.ResponseDto
import com.digi.delivery.dto.search.BaseSearch
import com.digi.delivery.entity.District
import com.digi.delivery.repository.DistrictRepository
import com.digi.delivery.service.DistrictService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${apiBasePath}/district")
@Api(tags = ["District"], description = "District")
class DistrictController @Autowired constructor(
    val districtService: DistrictService,
) : BaseController<DistrictDto, District, BaseSearchCriteria<BaseSearch>, DistrictService, DistrictRepository, Long>(
    districtService
) {
    @GetMapping("/province/{provinceId}")
    fun findByProvinceId(@PathVariable provinceId: Long): ResponseEntity<ResponseDto> {
        return ResponseDto.ok(districtService.findDistrictByProvinceId(provinceId))
    }

}

