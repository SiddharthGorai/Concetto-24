package com.iitism.concetto_24.Data

import com.google.gson.annotations.SerializedName

data class SponsorData (
    @SerializedName("img") val img: String,
    @SerializedName("link") val link: String
)