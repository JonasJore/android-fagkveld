package no.twoday.fagkveld.spells

import no.twoday.fagkveld.RetrofitInstance
import no.twoday.fagkveld.network.model.SpellModel

class SpellRepository {
    private val spellApi = RetrofitInstance.spellApi

    suspend fun getSpells(): List<SpellModel> {
        return spellApi.getSpells()
    }
}