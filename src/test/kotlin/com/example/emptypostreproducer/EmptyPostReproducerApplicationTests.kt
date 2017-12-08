package com.example.emptypostreproducer

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient


@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(EmptyPostReproducerApplication::class), webEnvironment = RANDOM_PORT)
class EmptyPostReproducerApplicationTests {

	@LocalServerPort
	protected var port = 0

	lateinit var webClient: WebTestClient
	lateinit var baseUri: String

	@Before
	fun setup() {
		baseUri = "http://localhost:" + port
		this.webClient = WebTestClient.bindToServer().baseUrl(baseUri).build()
	}

	@Test
	fun `Post with body`() {
		webClient.post()
				.uri("/testit")
				.header("X-TEST", "true")
				.syncBody("foo")
				.exchange()
				.expectStatus().isNoContent
	}

	@Test
	fun `Post without body`() {
		webClient.post()
				.uri("/testit")
				.header("X-TEST", "true")
				.exchange()
				.expectStatus().isNoContent
	}
}
