package navigation

// rutas deben de ser objetos serealizables pueder ser data class
// puede ser clase
import kotlinx.serialization.Serializable

@Serializable
object PokemonList

@Serializable
data class PokemonDetail(val pokemon: Int)
