package com.chriswk.themoviedb.model

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class LanguageTests : StringSpec() {
    init {
        "Should be able to serialize then deserialize" {
            val language = Language("nb", "Norwegian bokmål")
            val jsonStr = jacksonObjectMapper().writeValueAsString(language)
            println(jsonStr)
            val reread = jacksonObjectMapper().readValue<Language>(jsonStr)
            language shouldBe reread
        }
        "Read from json string" {
            val json = javaClass.getResource("/language.json")
            val language = jacksonObjectMapper().readValue<Language>(json)
            language.code shouldBe "nb"
            language.name shouldBe "Norwegian bokmål"
        }

        "Roundtrip" {
            val json = javaClass.getResource("/language.json")
            val language = jacksonObjectMapper().readValue<Language>(json)
            val jsonTest = json.readText()
            jacksonObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(language) shouldBe jsonTest
        }
    }
}

