package com.iitism.concetto_24.models


data class LoginResponse(
    val success: Boolean? = null,
    val user: User? = null,
    val accessToken: String? = null,
    val refreshToken: String? = null
)
