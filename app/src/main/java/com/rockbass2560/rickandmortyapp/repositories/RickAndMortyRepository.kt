package com.rockbass2560.rickandmortyapp.repositories

import com.rockbass2560.rickandmortyapp.models.CharacterPageRequest
import com.rockbass2560.rickandmortyapp.models.CharacterView
import com.rockbass2560.rickandmortyapp.models.Episode
import com.rockbass2560.rickandmortyapp.net.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class RickAndMortyRepository {

    suspend fun getPage(page: Int) : CharacterPageRequest {
        return suspendCoroutine {
            RetrofitInstance.rickAndMortyService.getCharacterPage(page).enqueue(object:
                Callback<CharacterPageRequest> {
                override fun onResponse(
                    call: Call<CharacterPageRequest>,
                    response: Response<CharacterPageRequest>
                ) {
                    it.resume(response.body()!!)
                }

                override fun onFailure(call: Call<CharacterPageRequest>, t: Throwable) {
                    it.resumeWithException(t)
                }

            })
        }

    }

    suspend fun getEpisodeByUrl(url: String) = suspendCoroutine<Episode> {
        RetrofitInstance.rickAndMortyService.getEpisodeByUrl(url).enqueue(
            object: Callback<Episode> {
                override fun onResponse(call: Call<Episode>, response: Response<Episode>) {
                    it.resume(response.body()!!)
                }

                override fun onFailure(call: Call<Episode>, t: Throwable) {
                    it.resumeWithException(t)
                }

            }
        )
    }

    suspend fun getCharacterByUrl(url: List<String>) = suspendCoroutine<CharacterView> {
        RetrofitInstance.rickAndMortyService.getCharacterByUrl(url).enqueue(
            object: Callback<CharacterView> {
                override fun onResponse(call: Call<CharacterView>, response: Response<CharacterView>) {
                    it.resume(response.body()!!)
                }

                override fun onFailure(call: Call<CharacterView>, t: Throwable) {
                    it.resumeWithException(t)
                }

            }
        )
    }

}