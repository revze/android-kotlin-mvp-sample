package id.revze.androidmvpkotlinsample.ui.main

import android.app.ProgressDialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import id.revze.androidmvpkotlinsample.R
import id.revze.androidmvpkotlinsample.model.AnimeCharacter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var context: Context
    private lateinit var animeCharacters: ArrayList<AnimeCharacter>
    private lateinit var rvAnimeCharacter: RecyclerView
    private lateinit var animeCharacterAdapter: AnimeCharacterAdapter
    private lateinit var progressDialog: ProgressDialog
    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter = MainPresenter(this)

        context = this
        animeCharacters = arrayListOf()
        rvAnimeCharacter = this.rv_anime_character
        rvAnimeCharacter.layoutManager = LinearLayoutManager(context)
        animeCharacterAdapter = AnimeCharacterAdapter(animeCharacters)
        rvAnimeCharacter.adapter = animeCharacterAdapter
        mainPresenter.getAnimeCharacters(context)
    }

    override fun onDetachView() {
        mainPresenter.onDetach()
    }

    override fun showLoader() {
        progressDialog = ProgressDialog(context)
        progressDialog.setMessage("Loading...")
        progressDialog.show()
    }

    override fun hideLoader() {
        progressDialog.dismiss()
    }

    override fun onSuccessGetAnimeCharacters(animeCharacters: ArrayList<AnimeCharacter>) {
        this.animeCharacters.addAll(animeCharacters)
        animeCharacterAdapter.notifyDataSetChanged()
    }

    override fun onFailedGetAnimeCharacters(message: String) {
        Snackbar.make(window.decorView.rootView, message, Snackbar.LENGTH_INDEFINITE).show()
    }

    override fun onDestroy() {
        onDetachView()
        super.onDestroy()
    }
}
