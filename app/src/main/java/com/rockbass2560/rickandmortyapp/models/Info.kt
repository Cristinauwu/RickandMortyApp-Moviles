package com.rockbass2560.rickandmortyapp.models

import com.google.gson.annotations.SerializedName

data class Info (
	@SerializedName("count") val count : Int,
	@SerializedName("pages") val pages : Int,
	@SerializedName("next") val next : String,
	@SerializedName("prev") val prev : String
)