package screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import components.FavriteRow
import components.PokedexGrid
import data.pokemonList

@Composable
fun MenuPokedexScreen(innerPadding: PaddingValues){
    val favoritePokemons = pokemonList.take(5)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Mis favoritos",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 16.dp)
        )

        FavriteRow(favoriteList = favoritePokemons)

        Text(
            text = "Todos mis pokemones",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 8.dp)
        )

        PokedexGrid(pokemonList = pokemonList)
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPokedexScreenPreview() {
    MenuPokedexScreen(innerPadding = PaddingValues(0.dp))
}