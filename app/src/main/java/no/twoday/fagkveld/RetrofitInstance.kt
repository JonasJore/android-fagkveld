package no.twoday.fagkveld

import no.twoday.fagkveld.network.CharactersApi
import no.twoday.fagkveld.network.SpellApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://hp-api.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val charactersApi: CharactersApi by lazy {
        retrofit.create(CharactersApi::class.java)
    }
    val spellApi: SpellApi by lazy {
        retrofit.create(SpellApi::class.java)
    }
}