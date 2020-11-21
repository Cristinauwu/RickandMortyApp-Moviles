package com.rockbass2560.rickandmortyapp.views

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.rockbass2560.rickandmortyapp.R
import com.rockbass2560.rickandmortyapp.adapters.CharacterEpisodeAdapter
import com.rockbass2560.rickandmortyapp.databinding.ActivityVerEpisodiosBinding
import com.rockbass2560.rickandmortyapp.models.CharacterView
import com.rockbass2560.rickandmortyapp.models.Episode
import com.rockbass2560.rickandmortyapp.viewmodels.ActivityVerEpisodioViewModel
import com.rockbass2560.rickandmortyapp.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.card_character.*


class ActivityVerEpisodios : AppCompatActivity() {
    val activityVerEpisodioViewModel : ActivityVerEpisodioViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflar la actividad
        val binding:ActivityVerEpisodiosBinding=DataBindingUtil.setContentView(this,R.layout.activity_ver_episodios)

      val episodeURL= intent.extras?.getString("url","https://rickandmortyapi.com/api/character/361")
        Log.d("episodeURL",episodeURL!!)

        activityVerEpisodioViewModel.episodeLiveData.observe(this,
            Observer<Episode> { episode ->
                binding.episode = episode
                binding.executePendingBindings()
            }
        )

        val recyclerViewCharacter=binding.recyclerViewDataCharacter
        recyclerViewCharacter.layoutManager=LinearLayoutManager(this)

        activityVerEpisodioViewModel.characterListLiveData.observe(this,
            Observer<List<CharacterView>> { characters ->
              val episodeAdapter=CharacterEpisodeAdapter(characters)
                recyclerViewCharacter.adapter=episodeAdapter
                episodeAdapter.notifyDataSetChanged()
            }
        )



        activityVerEpisodioViewModel.getEpisode(episodeURL)

    }
}

