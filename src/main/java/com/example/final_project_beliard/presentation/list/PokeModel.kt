package com.example.final_project_beliard.presentation.list

sealed class PokeModel

//Objects for success or error
data class PokeSuccess(val pokeList: List<Poke>) : PokeModel()
object PokemonLoader: PokeModel()
object PokemonError: PokeModel()