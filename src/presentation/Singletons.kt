package com.example.project_beliard.presentation

import com.example.project_beliard.presentation.api.CountryApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Singletons {
    companion object {
        val countryApi: CountryApi = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CountryApi::class.java)
    }
}

