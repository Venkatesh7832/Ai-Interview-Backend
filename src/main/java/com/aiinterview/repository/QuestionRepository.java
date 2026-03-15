package com.aiinterview.repository;

import com.aiinterview.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByCategory(Question.Category category);

    List<Question> findByDifficulty(Question.Difficulty difficulty);

    List<Question> findByCategoryAndDifficulty(Question.Category category, Question.Difficulty difficulty);

    @Query("SELECT q FROM Question q ORDER BY FUNCTION('RANDOM')")
    List<Question> findRandomQuestions(org.springframework.data.domain.Pageable pageable);

    @Query("SELECT q FROM Question q WHERE q.category = :category ORDER BY FUNCTION('RANDOM')")
    List<Question> findRandomByCategory(Question.Category category, org.springframework.data.domain.Pageable pageable);
}
