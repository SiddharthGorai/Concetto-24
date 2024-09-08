package com.iitism.concetto_24.services

import com.iitism.concetto_24.models.LeaderboardResponse
import com.iitism.concetto_24.models.LoginRequest
import com.iitism.concetto_24.models.LoginResponse
import com.iitism.concetto_24.models.OtpVerificationRequest
import com.iitism.concetto_24.models.OtpVerificationResponse
import com.iitism.concetto_24.models.RegisterAmbassadorRequest
import com.iitism.concetto_24.models.RegisterAmbassadorResponse
import com.iitism.concetto_24.models.RegisterRequest
import com.iitism.concetto_24.models.RegisterResponse
import com.iitism.concetto_24.models.ResendOtpRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthService {
    @POST("api/register")
    fun register(
        @Body request: RegisterRequest,
        @Query("source") source: String = "mobile"
    ): Call<RegisterResponse>

    @POST("api/verifyotp-mobile")
    fun verifyOtp(
        @Body request: OtpVerificationRequest,
        @Query("source") source: String = "mobile"
    ): Call<OtpVerificationResponse>

    @POST("api/login")
    fun login(
        @Body loginRequest: LoginRequest,
        @Query("source") source: String = "mobile"
    ): Call<LoginResponse>

    @POST("api/resendotp")
    fun resendOtp(
        @Body resendOtpRequest: ResendOtpRequest,
        @Query("source") source: String = "mobile"
    ): Call<Void>

    @POST("/campus")
    fun registerAmbassador(
        @Body request: RegisterAmbassadorRequest,
        @Query("source") source: String = "mobile"
    ): Call<RegisterAmbassadorResponse>

    @GET("/leaderboard-mobile")
    fun getLeaderboard(
        @Query("source") source: String = "mobile"
    ): Call<LeaderboardResponse>

}