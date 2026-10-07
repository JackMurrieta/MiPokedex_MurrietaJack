package navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import data.pokemonList
import screens.MenuPokedexScreen
import screens.PokemonDetailScreen

//conocer todas las rutas y controlador de las pantallas

@Composable
fun MyApp(innerPadding: PaddingValues){
    val navController = rememberNavController()

    NavHost(navController, startDestination = PokemonList){
        composable<PokemonList> {
            MenuPokedexScreen(innerPadding, { pokemonList  -> navController.navigate(PokemonDetail(pokemon))})
        }
        composable<PokemonDetail> {
            val pokemon = it.arguments?.getInt("pokemon") ?: -1
            PokemonDetailScreen(innerPadding, pokemon)
        }
    }
}