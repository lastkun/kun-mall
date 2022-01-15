package com.kunmall.gateway.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Primary
public class SwaggerProvider implements SwaggerResourcesProvider {

    public static final String API_URI = "/v2/api-docs";

    public static Map<String, String> moduleMap = new HashMap<>();

    static {
        moduleMap.put("后台API", "/api/admin");
    }

    @Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList<>();
        moduleMap.forEach((k, v) -> {
            resources.add(swaggerResource(k, v));
        });
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location + API_URI);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}