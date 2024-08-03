package com.digi.delivery.controller

import com.digi.delivery.base.controller.BaseController
import com.digi.delivery.base.repository.BaseSearchCriteria
import com.digi.delivery.dto.CommuneDto
import com.digi.delivery.dto.ResponseDto
import com.digi.delivery.entity.Commune
import com.digi.delivery.repository.CommuneRepository
import com.digi.delivery.service.CommuneService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${apiBasePath}/commune")
@Api(tags = ["Commune"], description = "Commune")
class CommuneController @Autowired constructor(
    val communeService: CommuneService,
) : BaseController<CommuneDto, Commune, BaseSearchCriteria<String>, CommuneService, CommuneRepository, Long>(
    communeService
) {
    @GetMapping("/lite")
    fun getCommuneLite(): ResponseEntity<ResponseDto> {
        return ResponseDto.ok(communeService.getAllCommuneLite())
    }

}
