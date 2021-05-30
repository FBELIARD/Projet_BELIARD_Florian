package com.example.final_project_beliard.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.final_project_beliard.presentation.Singletons
import com.example.final_project_beliard.presentation.api.PokemonListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryListViewModel : ViewModel() {

    val pokeList : MutableLiveData<CountryModel> = MutableLiveData()

    init {
        callApi()
    }

    private fun callApi() {
        pokeList.value = PokemonLoader
        Singletons.countryApi.getPokemonList().enqueue(object : Callback<PokemonListResponse> {
            override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                pokeList.value = PokemonError
            }

            override fun onResponse(call: Call<PokemonListResponse>, response: Response<PokemonListResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val pokemonResponse = response.body()!!
                    pokeList.value = CountrySuccess(pokemonResponse.results)
                } else {
                    pokeList.value = PokemonError
                }
            }

        })
    }
}

