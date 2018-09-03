package id.revze.androidmvpkotlinsample.ui.main

import android.content.Context
import id.revze.androidmvpkotlinsample.model.AnimeCharacter
import id.revze.androidmvpkotlinsample.api.Api
import id.revze.androidmvpkotlinsample.ui.base.Presenter

class MainPresenter(var mainView: MainView?) : Presenter<MainView> {

    override fun onDetach() {
        mainView = null
    }

    fun getAnimeCharacters(context: Context) {
        mainView?.showLoader()

        Api().getAnimeCharacters(context, object : Api.GetAnimeCharactersCallback {
            override fun onSuccess(animeCharacters: ArrayList<AnimeCharacter>) {
                mainView?.hideLoader()
                mainView?.onSuccessGetAnimeCharacters(animeCharacters)
            }

            override fun onError(message: String) {
                mainView?.hideLoader()
                mainView?.onFailedGetAnimeCharacters(message)
            }
        })
    }
}