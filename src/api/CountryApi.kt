package com.example.project_beliard.presentation.api


import retrofit2.Call
import retrofit2.http.GET

interface CountryApi {
    @GET("pokemon")
    fun getPokemonList(): Call<PokemonResponse>
}