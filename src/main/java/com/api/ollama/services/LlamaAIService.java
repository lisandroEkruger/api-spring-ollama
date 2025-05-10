package com.api.ollama.services;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class LlamaAIService {

    @Autowired
    private OllamaChatModel chatModel;

    @Value("${ollama.model}")
    private String model;

    public String generateResult(String prompt) {
        try {
            OllamaOptions options = new OllamaOptions();
            options.setModel(model);

            ChatResponse response = chatModel.call(new Prompt(prompt, options));

            if (response != null) {
                return response.getResult().getOutput().getText();
            }

            throw new RuntimeException("No response received from Ollama API");
        } catch (Exception ex) {
            throw new RuntimeException("Error while calling Ollama API: " + ex.getMessage(), ex);
        }
    }
}
