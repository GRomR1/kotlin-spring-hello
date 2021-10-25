package hello.world.controller

import hello.world.bean.Greeting
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.slf4j.Logger 
import org.slf4j.LoggerFactory

@RestController
@RequestMapping("/logs")
@Api(value = "logs", description = "Rest API for logs operations", tags = arrayOf("Logs API"))
class MessageController {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @ApiOperation(value = "Get empty json")
    @GetMapping("/empty")
    fun getEmpty(): String {
        return "{}"
    }

    @ApiOperation(value = "Display system env")
    @GetMapping("/env")
    fun getEnv(): String {
        var envVar: String = System.getenv("SOME_ENV_VAR") ?: "default_value"
        logger.info("envVar = " + envVar)
        return "envVar = '" + envVar + "'"
    }

    @ApiOperation(value = "Generate all type of log messages in the server")
    @GetMapping("/messages")
    fun helloKotlin(): String {
        logger.trace("A TRACE Message")
        logger.debug("A DEBUG Message")
        logger.info("An INFO Message")
        logger.warn("A WARN Message")
        logger.error("An ERROR Message")
        return "Hello World!"
    }

    @ApiOperation(value = "Generate an execption in the server ")
    @GetMapping("/exception")
    fun testException(): String {
        try {
            throw Exception("This is a test.")
        } catch (e: Exception) {
            logger.error("Exception caught:", e)
        }
        return "Exception caught"
    }
}