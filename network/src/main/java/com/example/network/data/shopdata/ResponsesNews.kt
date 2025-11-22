package com.example.network.data.shopdata

import androidx.resourceinspection.annotation.Attribute


data class ResponsesNews(
    val page: Int,
    val perPage: Int,
    val totalPages: Int,
    val totalItems: Int,
    val items: Array<News>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ResponsesNews

        if (page != other.page) return false
        if (perPage != other.perPage) return false
        if (totalPages != other.totalPages) return false
        if (totalItems != other.totalItems) return false
        if (!items.contentEquals(other.items)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = page
        result = 31 * result + perPage
        result = 31 * result + totalPages
        result = 31 * result + totalItems
        result = 31 * result + items.contentHashCode()
        return result
    }
}
