package no.twoday.fagkveld.network.model

import com.google.gson.annotations.SerializedName

data class CharacterModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("house")
    val house: String,
    @SerializedName("alive")
    val alive: Boolean,
    @SerializedName("image")
    val image: String,
)