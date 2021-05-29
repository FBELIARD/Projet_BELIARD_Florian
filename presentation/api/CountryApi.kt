package com.example.project_beliard.presentation.api


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryApi {
    @GET("pokemon")
    fun getPokemonList(): Call<PokemonListResponse>

    @GET("pokemon/{id}")
    fun getPokemonDetail(@Path("id") id: Int): Call<PokemonDetailResponse>
}