package no.twoday.fagkveld.network.model

import com.google.gson.annotations.SerializedName

data class SpellModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String
)
