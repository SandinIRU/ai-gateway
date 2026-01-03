package com.sandiniru.aigateway.controller;

import java.net.URI;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class RootController {

    @GetMapping("/")
    public Map<String, String> root() {
        return Map.of(
                "service", "ai-gateway",
                "chat", "/api/chat",
                "health", "/api/health",
                "openapi", "/v3/api-docs",
                "docs", "/swagger-ui.html"
        );
    }

    // ✅ So your old link /swagger-ui/index.html will NOT 404 anymore
    @GetMapping("/swagger-ui/index.html")
    public Mono<Void> swaggerIndexRedirect(ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.FOUND);
        response.getHeaders().setLocation(URI.create("/swagger-ui.html"));
        return response.setComplete();
    }
}
