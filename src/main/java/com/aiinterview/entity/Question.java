package com.aiinterview.entity;

import jakarta.persistence.*;

@Entity
@Table(name="questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private String expectedAnswer;

    private String followUpHint;

    public enum Category {
        TECHNICAL, BEHAVIORAL, SYSTEM_DESIGN, DATA_STRUCTURES,
        ALGORITHMS, DATABASE, JAVA, SPRING, MICROSERVICES, GENERAL
    }

    public enum Difficulty {
        EASY, MEDIUM, HARD
    }

    public Question() {}

    public Long getId(){ return id; }

    public void setId(Long id){ this.id=id; }

    public String getContent(){ return content; }

    public void setContent(String content){ this.content=content; }

    public Category getCategory(){ return category; }

    public void setCategory(Category category){ this.category=category; }

    public Difficulty getDifficulty(){ return difficulty; }

    public void setDifficulty(Difficulty difficulty){ this.difficulty=difficulty; }

    public String getExpectedAnswer(){ return expectedAnswer; }

    public void setExpectedAnswer(String expectedAnswer){ this.expectedAnswer=expectedAnswer; }

    public String getFollowUpHint(){ return followUpHint; }

    public void setFollowUpHint(String followUpHint){ this.followUpHint=followUpHint; }

	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}
}