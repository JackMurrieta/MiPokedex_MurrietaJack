package navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import screens.MenuPokedexScreen
import screens.PokemonDetailScreen

//conocer todas las rutas y controlador de las pantallas

@Composable
fun MyApp(innerPadding: PaddingValues){
    val navController = rememberNavController()

    NavHost(navController, startDestination = PokemonList){
        composable<PokemonList> {
            MenuPokedexScreen(innerPadding, { pokemonNum -> navController.navigate(PokemonDetail(pokemonNum))})
        }
        composable<PokemonDetail> {
            val args = it.toRoute<PokemonDetail>()
            PokemonDetailScreen(innerPadding, args.pokemon)
        }
    }
}
