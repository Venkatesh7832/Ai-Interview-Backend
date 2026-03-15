package com.aiinterview.service;

import com.aiinterview.dto.InterviewResponse;
import com.aiinterview.dto.InterviewResponse.QuestionDto;
import com.aiinterview.dto.InterviewResponse.SubmitAnswerRequest;
import com.aiinterview.entity.Question;
import com.aiinterview.repository.QuestionRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterviewService {

    private final QuestionRepository questionRepository;

    public InterviewService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    // Get all questions
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    // Convert questions to DTO for API response
    public List<QuestionDto> getQuestions() {

        List<Question> questions = questionRepository.findAll();

        return questions.stream()
                .map(q -> {
                    QuestionDto dto = new QuestionDto();
                    dto.setId(q.getId());
                    dto.setContent(q.getContent());
                    dto.setCategory(q.getCategory());
                    dto.setDifficulty(q.getDifficulty());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // Submit answer
    public InterviewResponse submitAnswer(SubmitAnswerRequest request) {

        Question question = questionRepository
                .findById(request.getQuestionId())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        InterviewResponse response = new InterviewResponse();

        response.setQuestionId(question.getId());
        response.setQuestionContent(question.getContent());
        response.setCategory(question.getCategory());
        response.setDifficulty(question.getDifficulty());

        response.setUserAnswer(request.getAnswer());

        // Temporary AI feedback (until AI API integration)
        response.setAiFeedback("Answer received. AI evaluation will be added later.");

        response.setScore(70); // dummy score
        response.setSubmittedAt(LocalDateTime.now());

        return response;
    }
}