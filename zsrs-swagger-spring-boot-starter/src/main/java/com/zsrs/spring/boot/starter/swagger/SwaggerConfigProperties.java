package com.zsrs.spring.boot.starter.swagger;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Create By IntelliJ IDEA
 *
 * @author XieHua
 * @date 2019-12-22
 */
@ConfigurationProperties(prefix = "swagger")
public class SwaggerConfigProperties {
    private Boolean enable = true;
    private String basePackage;
    private String title = "后台接口文档";
    private String description;
    private String url;
    private String version = "1.0";

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
