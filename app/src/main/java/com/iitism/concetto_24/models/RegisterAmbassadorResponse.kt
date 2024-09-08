package com.iitism.concetto_24.models

data class RegisterAmbassadorResponse(
    val success: Boolean,
    val userdata: User,
    val refCode: AmbassadorData
)
