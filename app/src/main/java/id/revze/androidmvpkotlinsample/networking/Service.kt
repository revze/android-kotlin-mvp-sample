package id.revze.androidmvpkotlinsample.networking

import android.content.Context
import com.google.gson.stream.MalformedJsonException
import id.revze.androidmvpkotlinsample.R
import id.revze.androidmvpkotlinsample.models.AnimeCharacter
import id.revze.androidmvpkotlinsample.models.AnimeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class Service {
    private val networkService = NetworkModule().getInstance().create(NetworkService::class.java)

    fun getAnimeCharacters(context: Context, callback: GetAnimeCharactersCallback) {
        val animeResponse = networkService.getAnimeCharacters()
        animeResponse.enqueue(object : Callback<AnimeResponse> {
            override fun onResponse(call: Call<AnimeResponse>, response: Response<AnimeResponse>) {
                if (response.isSuccessful()) callback.onSuccess(response.body()!!.animeCharacters)
                else callback.onError(context.getString(R.string.server_error))
            }

            override fun onFailure(call: Call<AnimeResponse>, t: Throwable) {
                if (t is MalformedJsonException) callback.onError(context.getString(R.string.server_error))
                else if (t is IOException) callback.onError(context.getString(R.string.network_error))
                else callback.onError(context.getString(R.string.something_went_wrong))
            }
        })
    }

    interface GetAnimeCharactersCallback {
        fun onSuccess(animeCharacters: ArrayList<AnimeCharacter>)

        fun onError(message: String)
    }
}