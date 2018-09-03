package id.revze.androidmvpkotlinsample.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiModule {
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://api.jikan.moe")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}