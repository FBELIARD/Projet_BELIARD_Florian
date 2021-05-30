package com.example.final_project_beliard.presentation.list

sealed class CountryModel

data class CountrySuccess(val pokeList: List<Country>) : CountryModel()
object PokemonLoader: CountryModel()
object PokemonError: CountryModel()