package no.twoday.fagkveld.ui.composable.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import no.twoday.fagkveld.network.model.SpellModel
import no.twoday.fagkveld.spells.SpellsViewModel
import no.twoday.fagkveld.ui.composable.H1
import no.twoday.fagkveld.ui.composable.Paragraph2
import no.twoday.fagkveld.ui.composable.cards.SpellCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpellScreen(
    spellsViewModel: SpellsViewModel,
    paddingValues: PaddingValues = PaddingValues()
) {
    val spells by remember {
        mutableStateOf(spellsViewModel.fetchedSpells)
    }

    var spellIndex by remember { mutableIntStateOf(0) }

    spellsViewModel.fetchSpells()

    var showSheet by remember { mutableStateOf(false) }
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = bottomSheetState
        ) {
            val clickedSpell: SpellModel = spells.value[spellIndex]
            Column(modifier = Modifier.padding(all = 24.dp)) {
                H1(text = "Spell description:")
                Paragraph2(text = spells.value[spellIndex].description)
            }
        }
    }



    LazyColumn(modifier = Modifier.padding(paddingValues)) {
        itemsIndexed(spells.value) { index, spell ->
            SpellCard(
                spell = spell,
                onClick = {
                    spellIndex = index
                    showSheet = true
                },
            )
        }
    }
}