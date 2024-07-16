//package com.digi.delivery.service
//
//import com.digi.delivery.dto.ProvinceDto
//import com.digi.delivery.entity.Province
//import com.digi.delivery.entity.Region
//import com.digi.delivery.repository.ProvinceRepository
//import com.digi.delivery.repository.RegionRepository
//import org.junit.jupiter.api.BeforeEach
//import org.junit.jupiter.api.Test
//import org.mockito.kotlin.*
//import java.util.*
//
//class ProvinceServiceTest {
//
//    private lateinit var provinceService: ProvinceService
//    private val provinceRepository: ProvinceRepository = mock()
//    private val regionRepository: RegionRepository = mock()
//
//    @BeforeEach
//    fun setup() {
//        provinceService = ProvinceService(provinceRepository, regionRepository)
//    }
//
//    @Test
//    fun `update province without region change`() {
//        val dto = ProvinceDto(code = "NewCode").apply { id = 1 }
//        val province = Province().apply {
//            id = 1
//            region = Region().apply { id = 1 }
//        }
//        whenever(provinceRepository.findById(dto.id!!)).thenReturn(Optional.of(province))
//        whenever(provinceRepository.save(any())).thenReturn(province)
//
//        provinceService.update(dto)
//
//        verify(provinceRepository).save(argThat {
//            code == "NewCode" && region?.id == 1L
//        })
//    }
//
//    @Test
//    fun `update province with region change`() {
//        val dto = ProvinceDto(id = 1, region = RegionDto(id = 2))
//        val oldRegion = Region(id = 1)
//        val newRegion = Region(id = 2)
//        val province = Province(id = 1, region = oldRegion)
//        whenever(provinceRepository.findById(dto.id!!)).thenReturn(Optional.of(province))
//        whenever(regionRepository.findById(dto.region!!.id!!)).thenReturn(Optional.of(newRegion))
//        whenever(provinceRepository.save(any())).thenReturn(province)
//
//        provinceService.update(dto)
//
//        verify(regionRepository).findById(2)
//        verify(provinceRepository).save(argThat {
//            region.id == 2
//        })
//    }
//
//    @Test
//    fun `update province without ID throws exception`() {
//        val dto = ProvinceDto()  // No ID provided
//
//        assertThrows<BusinessException> {
//            provinceService.update(dto)
//        }
//    }
//
//    @Test
//    fun `update non-existent province throws exception`() {
//        val dto = ProvinceDto(id = 999)
//        whenever(provinceRepository.findById(dto.id!!)).thenReturn(Optional.empty())
//
//        assertThrows<BusinessException> {
//            provinceService.update(dto)
//        }
//    }
//
//    @Test
//    fun `update province with non-existent new region throws exception`() {
//        val dto = ProvinceDto(id = 1, region = RegionDto(id = 999))
//        val province = Province(id = 1, region = Region(id = 1))
//        whenever(provinceRepository.findById(dto.id!!)).thenReturn(Optional.of(province))
//        whenever(regionRepository.findById(dto.region!!.id!!)).thenReturn(Optional.empty())
//
//        assertThrows<BusinessException> {
//            provinceService.update(dto)
//        }
//    }
//}