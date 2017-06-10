package com.chriswk.themoviedb.model

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class GenreTests : StringSpec() {
    init {
        "Should be able to serialize then deserialize" {
            val genre = Genre(1, "Thriller")
            val jsonStr = jacksonObjectMapper().writeValueAsString(genre)
            println(jsonStr)
            val reread = jacksonObjectMapper().readValue<Genre>(jsonStr)
            genre shouldBe reread
        }
        "Read from json string" {
            val json = javaClass.getResource("/genre.json")
            val genre = jacksonObjectMapper().readValue<Genre>(json)
            genre.id shouldBe 1L
            genre.name shouldBe "Thriller"
        }

        "Roundtrip" {
            val json = javaClass.getResource("/genre.json")
            val genre = jacksonObjectMapper().readValue<Genre>(json)
            val jsonTest = json.readText()
            jacksonObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(genre) shouldBe jsonTest
        }
    }
}
