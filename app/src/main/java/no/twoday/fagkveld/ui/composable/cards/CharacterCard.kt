package no.twoday.fagkveld.ui.composable.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import no.twoday.fagkveld.R
import no.twoday.fagkveld.network.model.CharacterModel
import java.util.UUID

@Composable
fun CharacterCard(character: CharacterModel) {
    Card(
        modifier = Modifier
            .padding(all = 12.dp)
            .fillMaxWidth()
    ) {
        Row {
            AsyncImage(
                modifier = Modifier
                    .size(146.dp),
                model = character.image,
                alignment = Alignment.CenterStart,
                error = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Character picture",
            )
            Column(modifier = Modifier.padding(vertical = 24.dp)) {
                Text(text = character.name)
                Text(text = character.house)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterCardPreview() {
    val character = CharacterModel(
        id = UUID.randomUUID().toString(),
        name = "Minerva McGonagall",
        house = "Gryffindor",
        alive = true,
        image = "https://ik.imagekit.io/hpapi/mcgonagall.jpg"
    )
    CharacterCard(character)
}