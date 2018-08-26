package id.revze.androidmvpkotlinsample.views.main

import id.revze.androidmvpkotlinsample.models.AnimeCharacter
import id.revze.androidmvpkotlinsample.views.base.View

interface MainView : View {
    fun showLoader()

    fun hideLoader()

    fun onFailedGetAnimeCharacters(message: String)

    fun onSuccessGetAnimeCharacters(animeCharacters: ArrayList<AnimeCharacter>)
}