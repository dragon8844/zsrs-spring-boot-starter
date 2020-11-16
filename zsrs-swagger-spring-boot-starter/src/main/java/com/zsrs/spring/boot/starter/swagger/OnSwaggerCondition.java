package com.zsrs.spring.boot.starter.swagger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

/**
 * Create By IntelliJ IDEA
 *
 * @author XieHua
 * @date 2019-12-23
 */
public class OnSwaggerCondition implements Condition {
    private static final Logger log = LoggerFactory.getLogger(OnSwaggerCondition.class);

    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String basePackage = conditionContext.getEnvironment().getProperty("swagger.basePackage");
        if (Objects.isNull(basePackage)) {
            log.warn("未获取到swagger.basePackage的值");
        }
        return true;
    }
}
