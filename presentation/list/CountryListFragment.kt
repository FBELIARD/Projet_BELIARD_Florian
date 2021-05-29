package com.example.project_beliard.presentation.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project_beliard.R
import com.example.project_beliard.presentation.Singletons
import com.example.project_beliard.presentation.api.CountryApi
import com.example.project_beliard.presentation.api.PokemonListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CountryListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private val adapter = CountryAdapter(listOf(), ::onClickedPokemon)

    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.country_recyclerview)


        recyclerView.apply {
            layoutManager = this@CountryListFragment.layoutManager
            adapter = this@CountryListFragment.adapter
        }


        //val list = getListFromCache()
        //if(list.isEmpty()) {
            callApi()
        //} else {
        //    showList(list)
        //}



    }

    //private fun getListFromCache(): List<Country> {

    //}

    private fun saveListIntoCache() {

    }

    private fun callApi() {
        Singletons.countryApi.getPokemonList().enqueue(object : Callback<PokemonListResponse> {
            override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<PokemonListResponse>, response: Response<PokemonListResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val pokemonResponse = response.body()!!
                    saveListIntoCache()
                    showList(pokemonResponse.results)
                }
            }

        })
    }

    private fun showList(pokeList: List<Country>) {
        adapter.updateList(pokeList)
    }

    private fun onClickedPokemon(id: Int) {

        findNavController().navigate(R.id.navigateToPokemonDetailFragment, bundleOf("pokemonId" to (id + 1)))
    }
}