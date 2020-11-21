package com.rockbass2560.rickandmortyapp.net.services

import com.rockbass2560.rickandmortyapp.models.CharacterPageRequest
import com.rockbass2560.rickandmortyapp.models.CharacterView
import com.rockbass2560.rickandmortyapp.models.Episode
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface RickAndMortyService {

    @GET("character")
    fun getCharacterPage(@Query("page") page: Int) : Call<CharacterPageRequest>

    @GET
    fun getEpisodeByUrl(@Url url: String) : Call<Episode>

    @GET
    fun getCharacterByUrl(@Url url: List<String>) : Call<CharacterView>
}