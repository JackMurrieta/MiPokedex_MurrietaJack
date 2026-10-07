package screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import data.getPokemonByNumber


/// pasar la screen pokemon detail a composable
@Composable
fun PokemonDetailScreen(innerPadding: PaddingValues, pokemon: Number){
    val pokemon = getPokemonByNumber(pokemon)
    Column(Modifier.padding(innerPadding)){
        Text(pokemon.name)
        Image(painterResource(pokemon.image),
            contentDescription = "${pokemon.name} image" )

    }

}