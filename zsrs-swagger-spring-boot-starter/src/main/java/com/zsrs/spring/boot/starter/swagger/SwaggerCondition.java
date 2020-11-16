package com.zsrs.spring.boot.starter.swagger;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * Create By IntelliJ IDEA
 *
 * @author XieHua
 * @date 2019-12-23
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnSwaggerCondition.class)
public @interface SwaggerCondition {
}
