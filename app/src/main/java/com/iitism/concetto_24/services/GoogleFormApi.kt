package com.iitism.concetto_24.services

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface GoogleFormApi {
    @FormUrlEncoded
    @POST("/forms/d/e/1FAIpQLScbcEkvHFHgzJh4rEx7n9KnLKCxNib40UNl_wldu3lj3-Z4lA/formResponse")
    fun sendFormData(
        @Field("entry.1385419009") name: String
    ): Call<Void>
}