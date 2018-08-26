package id.revze.androidmvpkotlinsample.networking

import id.revze.androidmvpkotlinsample.models.AnimeResponse
import retrofit2.Call
import retrofit2.http.GET

interface NetworkService {
    @GET("/anime/1/characters_staff")
    fun getAnimeCharacters(): Call<AnimeResponse>
}