package com.digi.delivery.util

import com.digi.delivery.base.repository.BaseSearchCriteria
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.Expression
import javax.persistence.criteria.Path
import javax.persistence.criteria.Predicate

object SearchHelper {
    const val SEARCH_LIKE = "%%%s%%"

    // Utility function to get a Pageable object
    fun getPageableObj(searchCriteria: BaseSearchCriteria<*>): Pageable {
        val direction = if (searchCriteria.direction.equals(Sort.DEFAULT_DIRECTION.toString(), ignoreCase = true)) {
            Sort.DEFAULT_DIRECTION
        } else {
            Sort.Direction.DESC
        }
        return PageRequest.of(
            searchCriteria.page ?: 0,
            searchCriteria.pageSize ?: BaseSearchCriteria.DEFAULT_ITEM_PER_PAGE,
            direction,
            searchCriteria.sortBy ?: BaseSearchCriteria.DEFAULT_SORT_BY
        )
    }

    // Utility function to create a LIKE predicate
    fun searchLike(path: Path<*>, searchValue: String, cb: CriteriaBuilder): Predicate {
        var safeSearchValue = searchValue.replace("%", "\\%").replace("_", "\\_")
        val valueLowerCase = String.format(SEARCH_LIKE, safeSearchValue.lowercase())
        var searchLikeByLowerCase: Expression<String> = cb.lower(path.`as`(String::class.java))
        return cb.like(searchLikeByLowerCase, valueLowerCase)
    }

    // Utility function to create a NOT LIKE predicate
    fun notLike(path: Path<*>, searchValue: String, cb: CriteriaBuilder): Predicate {
        var safeSearchValue = searchValue.replace("%", "\\%").replace("_", "\\_")
        val valueLowerCase = String.format(SEARCH_LIKE, safeSearchValue.lowercase())
        var searchLikeByLowerCase: Expression<String> = cb.lower(path.`as`(String::class.java))
        return cb.notLike(searchLikeByLowerCase, valueLowerCase)
    }
}
