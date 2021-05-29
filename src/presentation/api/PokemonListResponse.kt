package com.example.project_beliard.presentation.api

import com.example.project_beliard.presentation.list.Country

data class PokemonListResponse(
    val count: Int,
    val next: String,
    val results: List<Country>

)