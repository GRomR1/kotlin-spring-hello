package hello.world.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class ApplicationConfig {
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(getApiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("hello.world.controller"))
            .paths(PathSelectors.any())
            .build()
    }

    @Value("\${info.app.name}")
    lateinit var appName: String

    @Value("\${info.app.version}")
    lateinit var appVersion: String

    @Value("\${info.app.description}")
    lateinit var appDescription: String

    private fun getApiInfo(): ApiInfo {
        return ApiInfoBuilder()
            .title(appName)
            .version(appVersion)
            .description(appDescription)
            .build()
    }
}