package hello.world

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.slf4j.Logger 
import org.slf4j.LoggerFactory

@SpringBootApplication
class App

fun main(args: Array<String>) {
	runApplication<App>(*args)
}
