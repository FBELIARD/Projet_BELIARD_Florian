package com.example.final_project_beliard.presentation.list

sealed class PokeModel

data class PokeSuccess(val pokeList: List<Poke>) : PokeModel()
object PokemonLoader: PokeModel()
object PokemonError: PokeModel()