package com.example.final_project_beliard.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.final_project_beliard.R
import com.example.final_project_beliard.presentation.PokeSingletons
import com.example.final_project_beliard.presentation.api.PokemonDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class PokeDetailFragment : Fragment() {

    private lateinit var textViewName: TextView
    private lateinit var textViewId: TextView
    private lateinit var textViewHeight: TextView
    private lateinit var textViewWeight: TextView
    private lateinit var textId: TextView
    private lateinit var textHeight: TextView
    private lateinit var textWeight: TextView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_poke_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewName = view.findViewById(R.id.pokemon_detail_name)
        textViewId = view.findViewById(R.id.pokemon_detail_id)
        textViewHeight = view.findViewById(R.id.pokemon_detail_height)
        textViewWeight = view.findViewById(R.id.pokemon_detail_weight)
        callAPi()
    }

    private fun callAPi() {
        val id = arguments?.getInt("pokemonId") ?: -1
        PokeSingletons.pokeApi.getPokemonDetail(id).enqueue(object : Callback<PokemonDetailResponse>{
            override fun onFailure(call: Call<PokemonDetailResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<PokemonDetailResponse>, response: Response<PokemonDetailResponse>) {
                if(response.isSuccessful && response.body() != null) {
                    textViewName.text = response.body()!!.name
                    textViewId.text = response.body()!!.id
                    textViewHeight.text = response.body()!!.height
                    textViewWeight.text = response.body()!!.weight
                }
            }
        })
    }
}