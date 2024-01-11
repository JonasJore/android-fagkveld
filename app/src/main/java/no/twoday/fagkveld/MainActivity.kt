package no.twoday.fagkveld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import no.twoday.fagkveld.characters.CharactersViewModel
import no.twoday.fagkveld.spells.SpellsViewModel
import no.twoday.fagkveld.ui.composable.FagkveldTopAppBar
import no.twoday.fagkveld.ui.composable.screens.CharacterScreen
import no.twoday.fagkveld.ui.composable.screens.HomeScreen
import no.twoday.fagkveld.ui.composable.screens.SpellScreen
import no.twoday.fagkveld.ui.theme.FagkveldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val charactersViewModel: CharactersViewModel by viewModels()
        val spellsViewModel: SpellsViewModel by viewModels()

        setContent {
            FagkveldTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeApp(
                        charactersViewModel = charactersViewModel,
                        spellsViewModel = spellsViewModel
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeApp(
    charactersViewModel: CharactersViewModel,
    spellsViewModel: SpellsViewModel,
) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            FagkveldTopAppBar(
                title = "Fagkveld",
                icon = Icons.Filled.ArrowBack
            ) {
                navController.navigate(Route.HOME)
            }
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier.background(MaterialTheme.colorScheme.background)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { navController.navigate(Route.HOME) }) {
                        Icon(imageVector = Icons.Filled.Home, contentDescription = "Home")
                    }
                    IconButton(onClick = { navController.navigate(Route.CHARACTERS) }) {
                        Icon(imageVector = Icons.Filled.Person, contentDescription = "Characters")
                    }
                    IconButton(onClick = { navController.navigate(Route.SPELLS) }) {
                        Icon(imageVector = Icons.Filled.Star, contentDescription = "Spells")
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = Route.HOME) {
            composable(Route.HOME) {
                HomeScreen()
            }
            composable(Route.CHARACTERS) {
                CharacterScreen(
                    charactersViewModel = charactersViewModel,
                    paddingValues = innerPadding
                )
            }
            composable(Route.SPELLS) {
                SpellScreen(
                    spellsViewModel = spellsViewModel,
                    paddingValues = innerPadding
                )
            }
        }
    }
}

object Route {
    const val HOME = "home"
    const val CHARACTERS = "characters"
    const val SPELLS = "spells"
}