package com.example.final_project_beliard.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.final_project_beliard.R
import com.example.final_project_beliard.presentation.PokeSingletons
import com.example.final_project_beliard.presentation.api.PokeListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PokeListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var loader: ProgressBar
    private lateinit var textViewError: TextView

    private val adapter = PokeAdapter(listOf(), ::onClickedPokemon)

    private val viewModel: PokeListViewModel by viewModels()

    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_poke_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.poke_recyclerview)
        loader = view.findViewById(R.id.poke_loader)
        textViewError = view.findViewById(R.id.poke_error)


        recyclerView.apply {
            layoutManager = this@PokeListFragment.layoutManager
            adapter = this@PokeListFragment.adapter
        }

        viewModel.pokeList.observe(viewLifecycleOwner, Observer { pokemonModel ->
            loader.isVisible = pokemonModel is PokemonLoader
            textViewError.isVisible = pokemonModel is PokemonError

            if(pokemonModel is PokeSuccess) {
                adapter.updateList(pokemonModel.pokeList)
            } else {

            }

        })



    }

    private fun saveListIntoCache() {

    }

    private fun callApi() {
        PokeSingletons.pokeApi.getPokemonList().enqueue(object : Callback<PokeListResponse> {
            override fun onFailure(call: Call<PokeListResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<PokeListResponse>, response: Response<PokeListResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val pokemonResponse = response.body()!!
                    saveListIntoCache()
                    showList(pokemonResponse.results)
                }
            }

        })
    }

    private fun showList(pokeList: List<Poke>) {
        adapter.updateList(pokeList)
    }

    private fun onClickedPokemon(id: Int) {

        findNavController().navigate(R.id.navigateToPokemonDetailFragment, bundleOf("pokemonId" to (id + 1)))
    }
}