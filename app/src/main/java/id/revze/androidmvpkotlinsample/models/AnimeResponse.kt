package id.revze.androidmvpkotlinsample.models

import com.google.gson.annotations.SerializedName

class AnimeResponse(@SerializedName("character") val animeCharacters: ArrayList<AnimeCharacter>)