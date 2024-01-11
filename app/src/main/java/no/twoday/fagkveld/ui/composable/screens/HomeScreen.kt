package no.twoday.fagkveld.ui.composable.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import no.twoday.fagkveld.ui.composable.H1

@Composable
fun HomeScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        H1(text = "Android Fagkveld")
        AsyncImage(
            model = "https://www.twoday.no/hs-fs/hubfs/twoday/Brand%20Assets/Logo/twoday-wordmark-RGB_WHITE.png?width=250&height=72&name=twoday-wordmark-RGB_WHITE.png",
            contentDescription = "twoday logo",
            modifier = Modifier
                .background(Color.Black)
                .size(256.dp)
        )
    }
}