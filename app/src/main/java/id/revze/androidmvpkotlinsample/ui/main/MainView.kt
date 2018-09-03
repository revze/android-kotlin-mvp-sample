package id.revze.androidmvpkotlinsample.ui.main

import id.revze.androidmvpkotlinsample.model.AnimeCharacter
import id.revze.androidmvpkotlinsample.ui.base.View

interface MainView : View {
    fun showLoader()

    fun hideLoader()

    fun onFailedGetAnimeCharacters(message: String)

    fun onSuccessGetAnimeCharacters(animeCharacters: ArrayList<AnimeCharacter>)
}