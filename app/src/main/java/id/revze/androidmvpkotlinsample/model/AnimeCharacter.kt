package id.revze.androidmvpkotlinsample.model

import com.google.gson.annotations.SerializedName

class AnimeCharacter(@SerializedName("name") val name: String,
                     @SerializedName("role") val role: String,
                     @SerializedName("image_url") val imageUrl: String) {
}