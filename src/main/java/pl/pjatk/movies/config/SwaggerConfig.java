package pl.pjatk.movies.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket get() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("pl.pjatk.movies"))
                .build()
                .apiInfo(createApiInfo());
    }
    private ApiInfo createApiInfo() {
        return new ApiInfo(
                "REST API MovieService",
                "Description / Documentation of RentalService REST API.",
                "Terms of service",
                "Terms of service",
                new Contact("Krzysztof Szymczyk", "https://github.com/s23210","s23210@pjwstk.edu.pl"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
