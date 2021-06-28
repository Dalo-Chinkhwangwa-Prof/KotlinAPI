package com.dynamicdevz.ddkotlinmvp.model

import com.google.gson.annotations.SerializedName

data class JikanResponse(
    val last_page: Int,
    val request_cache_expiry: Int,
    val request_cached: Boolean,
    val request_hash: String,
    val results: List<Result>
)