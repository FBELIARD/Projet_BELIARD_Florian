package com.example.final_project_beliard.presentation.api

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