package com.aiinterview.dto;

import com.aiinterview.entity.Question;
import java.time.LocalDateTime;

public class InterviewResponse {

    private Long resultId;
    private Long questionId;
    private String questionContent;
    private Question.Category category;
    private Question.Difficulty difficulty;
    private String userAnswer;
    private String aiFeedback;
    private Integer score;
    private LocalDateTime submittedAt;

    public InterviewResponse() {}

    public InterviewResponse(Long resultId, Long questionId, String questionContent,
                             Question.Category category, Question.Difficulty difficulty,
                             String userAnswer, String aiFeedback,
                             Integer score, LocalDateTime submittedAt) {
        this.resultId = resultId;
        this.questionId = questionId;
        this.questionContent = questionContent;
        this.category = category;
        this.difficulty = difficulty;
        this.userAnswer = userAnswer;
        this.aiFeedback = aiFeedback;
        this.score = score;
        this.submittedAt = submittedAt;
    }

    public Long getResultId() { return resultId; }
    public void setResultId(Long resultId) { this.resultId = resultId; }

    public Long getQuestionId() { return questionId; }
    public void setQuestionId(Long questionId) { this.questionId = questionId; }

    public String getQuestionContent() { return questionContent; }
    public void setQuestionContent(String questionContent) { this.questionContent = questionContent; }

    public Question.Category getCategory() { return category; }
    public void setCategory(Question.Category category) { this.category = category; }

    public Question.Difficulty getDifficulty() { return difficulty; }
    public void setDifficulty(Question.Difficulty difficulty) { this.difficulty = difficulty; }

    public String getUserAnswer() { return userAnswer; }
    public void setUserAnswer(String userAnswer) { this.userAnswer = userAnswer; }

    public String getAiFeedback() { return aiFeedback; }
    public void setAiFeedback(String aiFeedback) { this.aiFeedback = aiFeedback; }

    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }

    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }


    // ================= AuthResponse =================

    public static class AuthResponse {

        private String token;
        private String tokenType;
        private Long userId;
        private String name;
        private String email;
        private String role;

        public AuthResponse() {}

        public AuthResponse(String token, String tokenType, Long userId,
                            String name, String email, String role) {
            this.token = token;
            this.tokenType = tokenType;
            this.userId = userId;
            this.name = name;
            this.email = email;
            this.role = role;
        }

        public String getToken() { return token; }
        public void setToken(String token) { this.token = token; }

        public String getTokenType() { return tokenType; }
        public void setTokenType(String tokenType) { this.tokenType = tokenType; }

        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }
    }


    // ================= SubmitAnswerRequest =================

    public static class SubmitAnswerRequest {

        private Long questionId;
        private String answer;

        public SubmitAnswerRequest() {}

        public Long getQuestionId() { return questionId; }
        public void setQuestionId(Long questionId) { this.questionId = questionId; }

        public String getAnswer() { return answer; }
        public void setAnswer(String answer) { this.answer = answer; }
    }


    // ================= QuestionDto =================

    public static class QuestionDto {

        private Long id;
        private String content;
        private Question.Category category;
        private Question.Difficulty difficulty;

        public QuestionDto() {}

        public QuestionDto(Long id, String content,
                           Question.Category category,
                           Question.Difficulty difficulty) {
            this.id = id;
            this.content = content;
            this.category = category;
            this.difficulty = difficulty;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getContent() { return content; }
        public void setContent(String content) { this.content = content; }

        public Question.Category getCategory() { return category; }
        public void setCategory(Question.Category category) { this.category = category; }

        public Question.Difficulty getDifficulty() { return difficulty; }
        public void setDifficulty(Question.Difficulty difficulty) { this.difficulty = difficulty; }
    }


    // ================= SessionSummary =================

    public static class SessionSummary {

        private Long userId;
        private String userName;
        private int totalAnswered;
        private double averageScore;
        private int highScoreCount;

        public SessionSummary() {}

        public SessionSummary(Long userId, String userName, int totalAnswered,
                              double averageScore, int highScoreCount) {
            this.userId = userId;
            this.userName = userName;
            this.totalAnswered = totalAnswered;
            this.averageScore = averageScore;
            this.highScoreCount = highScoreCount;
        }

        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }

        public String getUserName() { return userName; }
        public void setUserName(String userName) { this.userName = userName; }

        public int getTotalAnswered() { return totalAnswered; }
        public void setTotalAnswered(int totalAnswered) { this.totalAnswered = totalAnswered; }

        public double getAverageScore() { return averageScore; }
        public void setAverageScore(double averageScore) { this.averageScore = averageScore; }

        public int getHighScoreCount() { return highScoreCount; }
        public void setHighScoreCount(int highScoreCount) { this.highScoreCount = highScoreCount; }
    }
}