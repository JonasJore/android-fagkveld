package no.twoday.fagkveld.characters

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.twoday.fagkveld.network.model.CharacterModel

class CharactersViewModel : ViewModel() {
    private val repository = CharactersRepository()

    var fetchedCharacters: MutableState<List<CharacterModel>> = mutableStateOf(emptyList())
        private set

    fun fetchCharacters() {
        viewModelScope.launch {
            try {
                val characters = repository.getCharacters()
                fetchedCharacters.value = characters
            } catch (e: Exception) {
                Log.e("characterViewModel", e.toString())
            }
        }
    }
}