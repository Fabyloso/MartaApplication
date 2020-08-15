package com.fabyloso.martaapplication.data.remote.marta


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class MartaTrains : ArrayList<MartaTrains.MartaTrainsItem>(){
    @JsonClass(generateAdapter = true)
    data class MartaTrainsItem(
        @Json(name = "DESTINATION")
        val destination: String,
        @Json(name = "DIRECTION")
        val direction: String,
        @Json(name = "EVENT_TIME")
        val eventTime: String,
        @Json(name = "LINE")
        val line: String,
        @Json(name = "NEXT_ARR")
        val nextArr: String,
        @Json(name = "STATION")
        val station: String,
        @Json(name = "TRAIN_ID")
        val trainId: String,
        @Json(name = "WAITING_SECONDS")
        val waitingSeconds: String,
        @Json(name = "WAITING_TIME")
        val waitingTime: String
    )
}