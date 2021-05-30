package com.example.final_project_beliard.presentation.api

//values used for the detail fragment. These are the values shown on the screen
data class PokemonDetailResponse(
    val name: String,
    val id: String,
    val height: String,
    val weight: String,
    val types: List<PokemonSlot>
)

data class PokemonSlot(
    val slot: Int,
    val type: PokemonType
)

data class PokemonType(
    val name: String,
    val url: String
)