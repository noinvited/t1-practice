package ru.t1.practice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Практическое задание от t1",
                description = "Реализовано добавление опроса и отображение технологий",
                contact = @Contact(
                        name = "Rodionov Maxim",
                        email = "maxim.rodionov.dev@rambler.ru"
                )
        )
)
public class OpenApiConfig {
}
