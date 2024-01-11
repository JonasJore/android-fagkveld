package no.twoday.fagkveld.spells

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.twoday.fagkveld.network.model.SpellModel

class SpellsViewModel : ViewModel() {
    private val repository = SpellRepository()

    var fetchedSpells: MutableState<List<SpellModel>> = mutableStateOf(emptyList())
        private set

    fun fetchSpells() {
        viewModelScope.launch {
            try {
                val spells = repository.getSpells()
                fetchedSpells.value = spells
            } catch (e: Exception) {
                Log.e("SpellsViewModel", e.toString())
            }
        }
    }
}