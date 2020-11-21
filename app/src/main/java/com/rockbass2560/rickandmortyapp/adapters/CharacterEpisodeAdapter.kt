package com.rockbass2560.rickandmortyapp.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rockbass2560.rickandmortyapp.R
import com.rockbass2560.rickandmortyapp.databinding.ActivityVerEpisodiosBinding
import com.rockbass2560.rickandmortyapp.databinding.CardCharacterBinding
import com.rockbass2560.rickandmortyapp.databinding.CardCharacterByEpisodeBinding
import com.rockbass2560.rickandmortyapp.listeners.OnBottomReachedListener
import com.rockbass2560.rickandmortyapp.models.CharacterView
import com.rockbass2560.rickandmortyapp.views.ActivityVerEpisodios

class CharacterEpisodeAdapter(private val characters:List<CharacterView>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context);
            val episodeinfobinding = CardCharacterByEpisodeBinding.inflate(layoutInflater, parent, false)
            return EpisodeViewHolder(episodeinfobinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is EpisodeViewHolder) {
            val characterinfo = characters[position];
            holder.onBind(characterinfo);

        }
    }


    override fun getItemCount(): Int {
        return characters.size
    }

    inner class EpisodeViewHolder(private val episodeinfobinding:CardCharacterByEpisodeBinding ):
        RecyclerView.ViewHolder(episodeinfobinding.root){

        fun onBind(Character:CharacterView){
            episodeinfobinding.character=Character
            episodeinfobinding.executePendingBindings()
        }
    }

}