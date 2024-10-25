package com.appleroid.core.network.di

import com.appleroid.core.network.api.JoinApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        // Kotlinx Serialization 설정
        ignoreUnknownKeys = true // JSON에서 정의되지 않은 필드는 무시
        isLenient = true // 입력 값에 대해 유연하게 처리
        encodeDefaults = true // 기본값을 JSON에 포함하여 직렬화
    }

    @Provides
    @Singleton
    fun provideConverterFactory(json: Json): Converter.Factory = json.asConverterFactory("application/json".toMediaType())

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.example.com")
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideStatusApiService(retrofit: Retrofit): JoinApi = retrofit.create()
}
