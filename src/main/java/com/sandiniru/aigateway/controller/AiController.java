package com.sandiniru.aigateway.controller;

import com.sandiniru.aigateway.dto.ChatRequest;
import com.sandiniru.aigateway.dto.ChatResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class AiController {

  @Operation(summary = "Chat", description = "Demo endpoint for AI Gateway")
  @PostMapping(
      value = "/chat",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ChatResponse> chat(@Valid @RequestBody ChatRequest req) {
    return Mono.just(new ChatResponse("Demo reply: " + req.prompt()));
  }

  @Operation(summary = "Health check")
  @GetMapping("/health")
  public Mono<String> health() {
    return Mono.just("ok");
  }
}
