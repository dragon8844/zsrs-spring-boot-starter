package com.zsrs.spring.boot.starter.swagger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Create By IntelliJ IDEA
 *
 * @author XieHua
 * @date 2019-12-22
 */
@Configuration
@SwaggerCondition
@ConditionalOnClass(name = {"javax.servlet.ServletRegistration", "springfox.documentation.spring.web.plugins.Docket"})
@EnableConfigurationProperties(SwaggerConfigProperties.class)
@EnableSwagger2
public class SwaggerAutoConfiguration {

    private SwaggerConfigProperties swaggerConfigProperties;

    public SwaggerAutoConfiguration(SwaggerConfigProperties swaggerConfigProperties) {
        this.swaggerConfigProperties = swaggerConfigProperties;
    }

    @ConditionalOnMissingBean(Docket.class)
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerConfigProperties.getEnable())
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage(this.swaggerConfigProperties.getBasePackage()))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(this.swaggerConfigProperties.getTitle())
                .version(this.swaggerConfigProperties.getVersion())
                .description(this.swaggerConfigProperties.getDescription())
                .termsOfServiceUrl(this.swaggerConfigProperties.getUrl())
                .build();
    }
}
