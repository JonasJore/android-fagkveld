package no.twoday.fagkveld.network

import no.twoday.fagkveld.network.model.SpellModel
import retrofit2.http.GET

interface SpellApi {
    @GET("api/spells")
    suspend fun getSpells(): List<SpellModel>
}