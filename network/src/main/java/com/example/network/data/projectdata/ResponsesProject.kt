package com.example.network.data.projectdata



data class ResponsesProject(
    val page: Int,
    val perPage: Int,
    val totalPages: Int,
    val totalItems: String,
    val items: Array<Project>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ResponsesProject

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
        result = 31 * result + totalItems.hashCode()
        result = 31 * result + items.contentHashCode()
        return result
    }
}
