package com.aiinterview.service;

import org.springframework.stereotype.Service;

@Service
public class AIService {

    public String generateFollowUp(String question, String answer) {

        return "Follow-up question for: " + question;
    }
}