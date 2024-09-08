package com.iitism.concetto_24.models

data class OtpVerificationRequest(
    val otp: String,
    val email: String
)
