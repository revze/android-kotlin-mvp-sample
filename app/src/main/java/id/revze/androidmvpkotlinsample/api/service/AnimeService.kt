package id.revze.androidmvpkotlinsample.api.service

import id.revze.androidmvpkotlinsample.api.model.AnimeResponse
import retrofit2.Call
import retrofit2.http.GET

interface AnimeService {
    @GET("/anime/1/characters_staff")
    fun getAnimeCharacters(): Call<AnimeResponse>
}