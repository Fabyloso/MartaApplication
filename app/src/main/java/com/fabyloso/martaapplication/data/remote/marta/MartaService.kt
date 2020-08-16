package com.fabyloso.martaapplication.data.remote.marta

import retrofit2.Response
import retrofit2.http.GET

interface MartaService {

    @GET("RealtimeTrain/RestServiceNextTrain/GetRealtimeArrivals?apikey=0b428f59-da94-43e3-843a-c7501f9fd1b0")
    suspend fun getTrains(): Response<Array<MartaTrain>>
}
