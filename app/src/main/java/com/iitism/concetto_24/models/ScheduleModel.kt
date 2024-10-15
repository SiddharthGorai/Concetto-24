package com.iitism.concetto_24.models

data class ScheduleModel(
    var eventTime:String,
    var eventName: String,
    var eventVenue : String,
    val eventDescription : String,
    val eventPosterUrl : String
)