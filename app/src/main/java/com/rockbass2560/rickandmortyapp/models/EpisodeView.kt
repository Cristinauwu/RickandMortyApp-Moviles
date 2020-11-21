package com.rockbass2560.rickandmortyapp.models

data class EpisodeView (
    var name: String,
    var season: String,
    var air_date: String,
    var characters: List<String>
)