package com.backend.taskmanage.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.media.Schema;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Task Management API")
                .version("1.0")
                .description("API for managing tasks"))
            .addServersItem(new Server().url("http://localhost:8080")); // Update to your server URL
    }

    @Bean
    public OperationCustomizer globalHeaderCustomizer() {
        return (operation, handlerMethod) -> {
            operation.addParametersItem(new Parameter()
                .name("Authorization")
                .description("Bearer <token>")
                .required(false)
                .in("header")
                .schema(new Schema().type("string")));
            return operation;
        };
    }
}
