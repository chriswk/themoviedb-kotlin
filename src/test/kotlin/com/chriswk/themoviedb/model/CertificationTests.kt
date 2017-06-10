package com.chriswk.themoviedb.model

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class CertificationTests : StringSpec() {
    init {
        "Should be able to serialize then deserialize" {
            val certification = Certification("PG-13", "Minors under 13 needs Parental guidance", 1L)
            val jsonStr = jacksonObjectMapper().writeValueAsString(certification)
            println(jsonStr)
            val reread = jacksonObjectMapper().readValue<Certification>(jsonStr)
            certification shouldBe reread
        }
        "Read from json string" {
            val json = javaClass.getResource("/certification.json")
            val certification = jacksonObjectMapper().readValue<Certification>(json)
            certification.certification shouldBe "PG-13"
            certification.meaning shouldBe "Minors under 13 needs Parental guidance"
            certification.order shouldBe 1L
        }

        "Roundtrip" {
            val json = javaClass.getResource("/certification.json")
            val certification = jacksonObjectMapper().readValue<Certification>(json)
            val jsonTest = json.readText()
            jacksonObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(certification) shouldBe jsonTest
        }
    }
}