package components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import domain.Pokemon

// agregar respectivo preview

@Composable
fun MenuPokedex(pokemonList: List<Pokemon>, innerPadding: PaddingValues){
    LazyColumn() {
        items(pokemonList){
            pokemon -> PokemonRow(pokemon)
        }
    }
}

@Composable
fun FavriteRow(favoriteList:List<Pokemon>){
    LazyRow(){
        items(favoriteList){

        }
    }
}