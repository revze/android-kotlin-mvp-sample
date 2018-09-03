package id.revze.androidmvpkotlinsample.api.model

import com.google.gson.annotations.SerializedName
import id.revze.androidmvpkotlinsample.model.AnimeCharacter

class AnimeResponse(@SerializedName("character") val animeCharacters: ArrayList<AnimeCharacter>)