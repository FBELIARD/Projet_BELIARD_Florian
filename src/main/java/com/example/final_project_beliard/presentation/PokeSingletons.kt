package com.example.final_project_beliard.presentation

import com.example.final_project_beliard.presentation.PokeApplication.Companion.context
import com.example.final_project_beliard.presentation.api.PokeApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


class PokeSingletons {
    companion object {

        var cache: Cache = Cache(File(context?.cacheDir, "responses"), 10 * 1024 * 1024)

        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .cache(cache)
            .build()

        val pokeApi: PokeApi = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeApi::class.java)
    }


}

