package com.fabyloso.martaapplication.data.remote.marta

import retrofit2.Response
import retrofit2.http.GET

interface MartaService {

    @GET("RealtimeTrain/RestServiceNextTrain/GetRealtimeArrivals")
    suspend fun getTrains(): Response<MartaTrains>
}
