package com.aiinterview.controller;

import com.aiinterview.dto.InterviewResponse;
import com.aiinterview.service.InterviewService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interview")
public class InterviewController {

    private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    // Get questions
    @GetMapping("/questions")
    public ResponseEntity<List<InterviewResponse.QuestionDto>> getQuestions() {

        List<InterviewResponse.QuestionDto> questions =
                interviewService.getQuestions();

        return ResponseEntity.ok(questions);
    }

    // Submit answer
    @PostMapping("/submit")
    public ResponseEntity<InterviewResponse> submitAnswer(
            @RequestBody InterviewResponse.SubmitAnswerRequest request) {

        InterviewResponse response =
                interviewService.submitAnswer(request);

        return ResponseEntity.ok(response);
    }
}