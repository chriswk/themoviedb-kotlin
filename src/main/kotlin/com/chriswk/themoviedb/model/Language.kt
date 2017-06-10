package com.chriswk.themoviedb.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName("spoken_language")
data class Language(@JsonProperty("iso_639_1") val code: String, @JsonProperty("name") val name: String)