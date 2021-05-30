package com.example.final_project_beliard.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.final_project_beliard.presentation.PokeSingletons
import com.example.final_project_beliard.presentation.api.PokeListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokeListViewModel : ViewModel() {

    val pokeList : MutableLiveData<PokeModel> = MutableLiveData()

    init {
        callApi()
    }

    private fun callApi() {
        pokeList.value = PokemonLoader
        PokeSingletons.pokeApi.getPokemonList().enqueue(object : Callback<PokeListResponse> {
            override fun onFailure(call: Call<PokeListResponse>, t: Throwable) {
                pokeList.value = PokemonError
            }

            override fun onResponse(call: Call<PokeListResponse>, response: Response<PokeListResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val pokemonResponse = response.body()!!
                    pokeList.value = PokeSuccess(pokemonResponse.results)
                } else {
                    pokeList.value = PokemonError
                }
            }

        })
    }
}

