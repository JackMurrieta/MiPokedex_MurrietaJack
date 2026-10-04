package components

import domain.Pokemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mipokedex_murrietajackt.ui.theme.Green
import data.pokemonList

//Crea una función composable llamada PokemonRow que reciba como parámetro un objeto de tipo Pokemon llamado pokemon



@Composable
fun pokemonRow(pokemon: Pokemon){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = pokemon.image),
            contentDescription = "${pokemon.name} image",
            modifier = Modifier
                .width(80.dp)
                .padding(10.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(0.7f),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.labelLarge
            )

            Text(
                text = pokemon.description,
                fontSize = 10.sp
            )

            Row(
                modifier = Modifier.fillMaxWidth(0.85f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Height: ${pokemon.height}",
                    style = MaterialTheme.typography.labelMedium
                )

                Text(
                    text = "Weight: ${pokemon.weight}",
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }

        Text(
            text = pokemon.num.toString(),
            modifier = Modifier
                .align(Alignment.Top)
                .background(Green)
                .padding(horizontal = 5.dp, vertical = 2.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonRowPreview() {
    pokemonRow(pokemon = pokemonList[0])
}