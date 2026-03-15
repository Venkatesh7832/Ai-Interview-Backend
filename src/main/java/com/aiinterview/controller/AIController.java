package com.aiinterview.controller;

import com.aiinterview.service.AIService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class AIController {

    private final AIService aiService;

    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    // Health check
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {

        return ResponseEntity.ok(
                Map.of("status", "AI service is running"));
    }

    // Generate follow-up question
    @PostMapping("/followup")
    public ResponseEntity<Map<String, String>> followup(
            @RequestBody Map<String, String> body) {

        String followUp =
                aiService.generateFollowUp(
                        body.get("question"),
                        body.get("answer"));

        return ResponseEntity.ok(
                Map.of("followUp", followUp));
    }
}