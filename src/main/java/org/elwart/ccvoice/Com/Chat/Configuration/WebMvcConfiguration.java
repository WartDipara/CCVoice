package org.elwart.ccvoice.Com.Chat.Configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * web layer config
 * jwt or sth else
 */
@Configuration
@Slf4j
@EnableSwagger2
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
    @Bean
    public Docket docket() {
        log.info("generating interface document...");
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("CC_VOICE interface")
                .version("1.0")
                .description("CC_VOICE interface")
                .build();
        //not finish yet
        return new Docket(DocumentationType.SWAGGER_2);
    }

}
