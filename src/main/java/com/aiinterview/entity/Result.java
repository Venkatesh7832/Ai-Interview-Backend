package com.aiinterview.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userAnswer;

    private String aiFeedback;

    private int score;

    private LocalDateTime submittedAt;

    @ManyToOne
    private User user;

    @ManyToOne
    private Question question;

    public Result(){}

    public Long getId(){ return id; }

    public void setId(Long id){ this.id=id; }

    public String getUserAnswer(){ return userAnswer; }

    public void setUserAnswer(String userAnswer){ this.userAnswer=userAnswer; }

    public String getAiFeedback(){ return aiFeedback; }

    public void setAiFeedback(String aiFeedback){ this.aiFeedback=aiFeedback; }

    public int getScore(){ return score; }

    public void setScore(int score){ this.score=score; }

    public LocalDateTime getSubmittedAt(){ return submittedAt; }

    public void setSubmittedAt(LocalDateTime submittedAt){ this.submittedAt=submittedAt; }

    public User getUser(){ return user; }

    public void setUser(User user){ this.user=user; }

    public Question getQuestion(){ return question; }

    public void setQuestion(Question question){ this.question=question; }
}