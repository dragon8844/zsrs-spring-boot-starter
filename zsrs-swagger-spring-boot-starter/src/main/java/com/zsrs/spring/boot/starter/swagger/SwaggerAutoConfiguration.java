package com.zsrs.spring.boot.starter.swagger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

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
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("Authorization").description("user token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build(); //header中的ticket参数非必填，传空也可以
        pars.add(tokenPar.build());    //根据每个方法名也知道当前方法在设置什么参数

        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerConfigProperties.getEnable())
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage(this.swaggerConfigProperties.getBasePackage()))
                .build()
                .globalOperationParameters(pars);
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
