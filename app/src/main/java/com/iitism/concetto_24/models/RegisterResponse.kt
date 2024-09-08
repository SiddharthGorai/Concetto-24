package com.iitism.concetto_24.models

data class RegisterResponse(
    val user: User? = null,
    val message: String? = null,
    val accessToken: String? = null,
    val refreshToken: String? = null,
    val error: String? = null
)
