package id.revze.androidmvpkotlinsample.views.main

import android.content.Context
import id.revze.androidmvpkotlinsample.models.AnimeCharacter
import id.revze.androidmvpkotlinsample.networking.Service
import id.revze.androidmvpkotlinsample.views.base.Presenter

class MainPresenter : Presenter<MainView> {

    private var mainView: MainView? = null

    override fun onAttach(view: MainView) {
        this.mainView = view
    }

    override fun onDetach() {
        mainView = null
    }

    fun getAnimeCharacters(context: Context) {
        mainView?.showLoader()

        Service().getAnimeCharacters(context, object : Service.GetAnimeCharactersCallback {
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