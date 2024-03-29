package com.example.demo.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

@Configuration
public class ThymeleafConfig {
    @Bean
    public SpringResourceTemplateResolver thymeleafTemplateResolver(
            SpringResourceTemplateResolver defaultTemplateResolver,
            Thymeleaf3Properties thymeleaf3Properties
    ) {
        defaultTemplateResolver.setUseDecoupledLogic(thymeleaf3Properties.decoupledLogic());

        return defaultTemplateResolver;
    }

//    @RequiredArgsConstructor
//    @Getter
//    @ConfigurationProperties("spring.thymeleaf3")
//    public static class Thymeleaf3Properties{
//            private final boolean decoupledLogic;
//    }
    @ConfigurationProperties("spring.thymeleaf3")
    public record Thymeleaf3Properties (boolean decoupledLogic){}
}
