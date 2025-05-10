package com.api.ollama.controllers;

import com.api.ollama.exception.GlobalExceptionHandler;
import com.api.ollama.services.LlamaAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
public class OLlamaController {

    @Autowired
    private LlamaAIService llamaAIService;

    @GetMapping("/api/v1/generate")
    public String generate(@RequestParam(value = "promptMessage") String promptMessage) {
        try {
            return llamaAIService.generateResult(promptMessage);
        } catch (Exception ex) {
            throw new RuntimeException("Error while generating result: " + ex.getMessage(), ex);
        }
    }
}
