package domain

data class PokedexState(val team: List<Pokemon> = emptyList<Pokemon>(),
    val leastCaptured: Pokemon? = null)
