package com.sandiniru.aigateway.dto;

import jakarta.validation.constraints.NotBlank;

public record ChatRequest(@NotBlank String prompt) {}
