package com.digi.delivery.repository.spec

import com.digi.delivery.base.entity.BaseEntity
import com.digi.delivery.entity.Commune
import com.digi.delivery.util.SearchHelper
import org.springframework.data.jpa.domain.Specification

const val format = "%%s%"

class BaseSpec<T : BaseEntity> {

    fun hasCode(code: String): Specification<T> =
        Specification { root, _, cb ->
            cb.like(cb.lower(root.get("code")), String.format(SearchHelper.SEARCH_LIKE, code))
        }

    fun hasName(name: String): Specification<T> =
        Specification { root, _, cb ->
            cb.like(cb.lower(root.get("name")), String.format(SearchHelper.SEARCH_LIKE, name))
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
