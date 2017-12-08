package com.example.emptypostreproducer

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class EmptyPostReproducerApplication {

	@Bean
	fun backend() = WireMockServer(9090).apply {
		stubFor(any(urlEqualTo("/testit")).willReturn(noContent()))
		start()
	}

}

fun main(args: Array<String>) {
	runApplication<EmptyPostReproducerApplication>(*args)
}
