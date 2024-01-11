package no.twoday.fagkveld.characters

import no.twoday.fagkveld.RetrofitInstance
import no.twoday.fagkveld.network.model.CharacterModel

class CharactersRepository {
    private val charactersApi = RetrofitInstance.charactersApi

    suspend fun getCharacters(): List<CharacterModel> {
        return charactersApi.getCharacters()
    }
}