package com.fabyloso.martaapplication.data.remote.marta

import com.fabyloso.martaapplication.data.remote.BaseRemoteSource
import javax.inject.Inject

class MartaRemoteSource @Inject constructor(private val martaService: MartaService) :
    BaseRemoteSource() {
    suspend fun getTrains() = getResult { martaService.getTrains() }
}