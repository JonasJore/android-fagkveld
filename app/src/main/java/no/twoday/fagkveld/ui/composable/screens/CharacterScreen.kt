package no.twoday.fagkveld.ui.composable.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import no.twoday.fagkveld.characters.CharactersViewModel
import no.twoday.fagkveld.ui.composable.cards.CharacterCard

@Composable
fun CharacterScreen(
    charactersViewModel: CharactersViewModel,
    paddingValues: PaddingValues
) {
    charactersViewModel.fetchCharacters()

    val chars by remember {
        mutableStateOf(charactersViewModel.fetchedCharacters)
    }

    LazyColumn(modifier = Modifier.padding(paddingValues)) {
        items(chars.value) { character ->
            CharacterCard(character = character)
        }
    }
}