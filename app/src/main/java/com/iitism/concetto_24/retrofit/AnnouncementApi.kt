package com.iitism.concetto_24.retrofit

import com.iitism.concetto_24.models.Announcement
import retrofit2.Call
import retrofit2.http.GET

interface AnnouncementApi {
    @GET("/api/announcements")
    fun getAnnouncements(): Call<List<Announcement>>
}