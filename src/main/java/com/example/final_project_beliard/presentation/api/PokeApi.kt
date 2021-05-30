package com.example.final_project_beliard.presentation.api


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {

    //function for obtaining all the Pokemon in the list
    @GET("pokemon/?offset=0&limit=10000")
    fun getPokemonList(): Call<PokeListResponse>

    //function for obtaining the detail of the responses of the API for the detail fragment
    @GET("pokemon/{id}")
    fun getPokemonDetail(@Path("id") id: Int): Call<PokemonDetailResponse>

    //Dummy function for expanding the code
    @GET("pokemon/{id}")
    fun getPokemonType(@Path("id") id: Int): Call<PokemonType>
}