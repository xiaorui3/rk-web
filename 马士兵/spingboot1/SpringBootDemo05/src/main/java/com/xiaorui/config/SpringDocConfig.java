package com.xiaorui.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI restfulOpenAPI(){
        Info info = new Info().title("用户系统").description("用户管理系统").version("1.0");
        return new OpenAPI().info(info);
    }
}
