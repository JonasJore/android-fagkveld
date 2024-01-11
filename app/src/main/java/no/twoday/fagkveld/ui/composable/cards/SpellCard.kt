package no.twoday.fagkveld.ui.composable.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import no.twoday.fagkveld.network.model.SpellModel
import no.twoday.fagkveld.ui.composable.H1

@Composable
fun SpellCard(
    spell: SpellModel,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .padding(all = 12.dp)
            .fillMaxWidth(),
        onClick = { onClick() }
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            H1(text = spell.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpellCardPreview() {
    SpellCard(spell = SpellModel(id = "", name = "Crucio", "Unforgivable curse"))
}