package com.example.dopame.network.di

import android.content.Context
import com.example.dopame.network.adapter.ApiResultCallAdapterFactory
import com.example.dopame.network.interceptor.AuthInterceptor
import com.example.dopame.network.service.MiningService
import com.example.dopame.data.repository.MiningRepository
import com.example.dopame.data.repository.MiningRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    //private const val BASE_URL = BuildConfig.BASE_URL
    private const val BASE_URL = ""

    @Singleton
    @Provides
    fun provideOkHttpClient(
        tokenInterceptor: AuthInterceptor,
        @ApplicationContext context: Context
    ): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(tokenInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()

    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(ApiResultCallAdapterFactory())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideMiningService(retrofit: Retrofit): MiningService {
        return retrofit.create(MiningService::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class RepositoryModule {
        @Singleton
        @Binds
        abstract fun providesDoctorRepository(doctorRepositoryImpl: MiningRepositoryImpl): MiningRepository
    }
}