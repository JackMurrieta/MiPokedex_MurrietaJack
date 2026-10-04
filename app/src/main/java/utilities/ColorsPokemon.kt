package utilities

import androidx.compose.ui.graphics.Color
import com.example.mipokedex_murrietajackt.ui.theme.*


fun getColorByType(tipoPokemon:String) : Array<Color>  {
    //primeros tipos
    /*
    * Normal
    * Water
    * Fire
    * Psych
    * Ghost
    * Bug
    * Poison
    * Grass
    * Ground
    * Rock*/
    //hashmap mejor rendimiento
    //String validarlo y pasarlo a minuscula buscar en el hashmap

    val tipoPokemonLower = tipoPokemon.trim().lowercase()

    val colorMap: HashMap<String, Array<Color>> = hashMapOf(
        "normal" to arrayOf(Normal, offWhite),
        "water" to arrayOf(Water, offWhite),
        "fire" to arrayOf(Fire, offWhite),
        "psychic" to arrayOf(Psych, offWhite),
        "ghost" to arrayOf(Ghost, offWhite),
        "bug" to arrayOf(Bug, offWhite),
        "poison" to arrayOf(Poison, offWhite),
        "grass" to arrayOf(Grass, offWhite),
        "ground" to arrayOf(Ground, offWhite),
        "rock" to arrayOf(Rock, offWhite),
        //segundos tipos
        "electric" to arrayOf(Electric,DarkGray),
        "fairy" to arrayOf(Fairy,DarkGray),
        "fight" to arrayOf(Fight,DarkGray),
        "flying" to arrayOf(Flying,DarkGray)

    )

    return colorMap[tipoPokemonLower] ?: arrayOf(DarkGray, offWhite)
}