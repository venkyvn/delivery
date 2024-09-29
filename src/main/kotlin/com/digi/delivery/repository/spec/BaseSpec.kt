package com.digi.delivery.repository.spec

import com.digi.delivery.base.entity.BaseEntity
import com.digi.delivery.dto.search.ReceiptSearch
import com.digi.delivery.entity.Commune
import com.digi.delivery.util.SearchHelper
import org.slf4j.LoggerFactory
import org.springframework.data.jpa.domain.Specification
import java.util.*
import kotlin.reflect.full.memberProperties

const val format = "%%s%"

class BaseSpec<E : BaseEntity> {

    fun hasCode(code: String): Specification<E> =
        Specification { root, _, cb ->
            cb.like(cb.lower(root.get("code")), String.format(SearchHelper.SEARCH_LIKE, code))
        }

    fun hasName(name: String): Specification<E> =
        Specification { root, _, cb ->
            cb.like(cb.lower(root.get("name")), String.format(SearchHelper.SEARCH_LIKE, name))
        }

    fun searchByFieldValue(searchField: String, searchValue: Any): Specification<E>? =
        Specification { root, _, cb ->
            when (searchValue) {
                is String -> {
                    // Handle string search using LIKE for case-insensitive match
                    cb.like(
                        cb.lower(root.get(searchField)), String.format(
                            SearchHelper.SEARCH_LIKE,
                            searchValue.lowercase(Locale.getDefault())
                        )
                    )
                }

                is Enum<*> -> {
                    cb.equal(root.get<Enum<*>>(searchField), searchValue)

                }

                else -> {
                    // Handle other types if needed, for now, return null to indicate unsupported type
                    null
                }
            }
        }

    //TODO: refactor later, only support string this time
    fun getReceiptSpec(receiptSearch: ReceiptSearch?): Specification<E> {
        var spec: Specification<E> = Specification.where(null)
        receiptSearch?.let { search ->
            val nonNullProperties = ReceiptSearch::class.memberProperties.filter { it.get(search) != null }
            for (property in nonNullProperties) {
                val fieldName = property.name
                val fieldValue = property.get(search) as? String
                if (!fieldValue.isNullOrBlank()) {
                    spec = spec.and(searchByFieldValue(fieldName, fieldValue))
                }
            }
        }
        return spec
    }
}


object CommuneSpec {
    fun hasShipmentType(shipmentType: String): Specification<Commune> =
        Specification { root, _, cb ->
            cb.like(cb.lower(root.get("shipmentType")), String.format(SearchHelper.SEARCH_LIKE, shipmentType))
        }

    fun hasLabel(label: String): Specification<Commune> =
        Specification { root, _, cb ->
            cb.like(cb.lower(root.get("label")), String.format(SearchHelper.SEARCH_LIKE, label))
        }
}
