package com.example.final_project_beliard.presentation.api

import com.example.final_project_beliard.presentation.list.Poke

data class PokeListResponse(
    val count: Int,
    val next: String,
    val results: List<Poke>
)