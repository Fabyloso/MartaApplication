package com.fabyloso.martaapplication

import com.fabyloso.martaapplication.data.remote.marta.MartaRemoteController
import com.fabyloso.martaapplication.data.remote.marta.MartaRemoteSource
import com.fabyloso.martaapplication.data.remote.marta.MartaService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object DataModule {

    @Provides
    fun provideMartaRemoteSource(martaService: MartaService) = MartaRemoteSource(martaService)

    @Provides
    fun provideMartaService(): MartaService =
        MartaRemoteController().retrofit.create(MartaService::class.java)

}