package no.twoday.fagkveld.network

import no.twoday.fagkveld.network.model.CharacterModel
import retrofit2.http.GET

interface CharactersApi {
    @GET("api/characters")
    suspend fun getCharacters(): List<CharacterModel>
}