package com.chriswk.themoviedb.model

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec


class StatusCodeTests : StringSpec() {
    init {
        "Should be able to serialize and deserialize" {
            val code = StatusCode(1, "Successful")
            val json = jacksonObjectMapper().writeValueAsString(code)
            val sameCode = jacksonObjectMapper().readValue<StatusCode>(json)
            sameCode shouldBe code
        }
        "Should read from file" {
            val code = jacksonObjectMapper().readValue<StatusCode>(javaClass.getResource("/statuscode.json"))
            code.code shouldBe 1
            code.message shouldBe "Success"
        }
    }
}

