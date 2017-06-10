package com.chriswk.themoviedb.model

import com.fasterxml.jackson.annotation.JsonProperty

data class StatusCode(@JsonProperty("status_code") val code: Int, @JsonProperty("status_message") val message: String)
