package hello.world

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) {

	@BeforeAll
	fun setup() {
		println(">> Setup")
	}

	@Test
	fun `Assert log empty`() {
		println(">> Assert log empty")
		val entity = restTemplate.getForEntity<String>("/logs/empty")
		assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
	}

	@Test
	fun `Assert api hello user`() {
		println(">> Assert api hello user")
		val user = "Alice"
		val entity = restTemplate.getForEntity<String>("/api/hello/${user}")
		assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
		assertThat(entity.body).contains(user, "Hello Alice")
	}

    @Test
    fun `Assert TODO`() {
        println(">> TODO")
    }

	@AfterAll
	fun teardown() {
		println(">> Tear down")
	}

}
