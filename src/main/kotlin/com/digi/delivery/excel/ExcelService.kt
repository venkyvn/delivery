package com.digi.delivery.excel

import com.digi.delivery.entity.RegionFreightPrice
import com.digi.delivery.entity.RegionRate
import com.digi.delivery.repository.RegionFreightPriceRepository
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.apache.poi.util.IOUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service

//@Service
class ExcelService {
    init {
        IOUtils.setByteArrayMaxOverride(200 * 1024 * 1024) // 200 MB
    }

//    @Autowired
    lateinit var regionFreightPriceRepository: RegionFreightPriceRepository

    fun readExcelFile() {
        val data = mutableListOf<Map<String, String>>()

        val resource = ClassPathResource("sampleData/test2.xlsx")
        val inputStream = resource.inputStream
        val workbook = WorkbookFactory.create(inputStream)
        val sheet = workbook.getSheetAt(0)
        val headerRow = sheet.getRow(0)
        val headers = mutableListOf<String>()

        for (cell in headerRow) {
            headers.add(cell.toString())
        }

        val regionWeightRow = sheet.getRow(1)
        val regionRates = mutableListOf<String>()
        for (cell in regionWeightRow) {
            if (cell.toString().contains("kg")) {
                regionRates.add(cell.toString())
            }
        }

        var i = 0
        for (rowIndex in 3 until 10) {
            val row = sheet.getRow(rowIndex)
            regionRates.forEach {
                val rates = mutableSetOf<RegionRate>()
                regionRates.forEach {
                    RegionRate().apply {
//                        price = row.getCell(2).toString()
                    }

                }

                var regionPrice = RegionFreightPrice().apply {
                    name = row.getCell(1).toString()
                    code = row.getCell(2).toString()
                    label = it
                }
            }

            i++
        }

        // Reading the rest of the rows
//        for (rowIndex in 1 until sheet.physicalNumberOfRows) {
//            val row = sheet.getRow(rowIndex)
//            val rowData = mutableMapOf<String, String>()
//
//            for (cellIndex in 0 until row.physicalNumberOfCells) {
//                rowData[headers[cellIndex]] = row.getCell(cellIndex).toString()
//            }
//
//            data.add(rowData)
//        }

        workbook.close()
    }
}
