package com.example.final_project_beliard.presentation.api


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    @GET("pokemon/?offset=0&limit=10000")
    fun getPokemonList(): Call<PokeListResponse>

    @GET("pokemon/{id}")
    fun getPokemonDetail(@Path("id") id: Int): Call<PokemonDetailResponse>

    @GET("pokemon/{id}")
    fun getPokemonType(@Path("id") id: Int): Call<PokemonType>
}