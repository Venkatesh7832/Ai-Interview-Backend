package com.aiinterview.repository;

import com.aiinterview.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.aiinterview.entity.Result;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findByUserIdOrderBySubmittedAtDesc(Long userId);

    List<Result> findByUserIdAndQuestionCategory(Long userId, com.aiinterview.entity.Question.Category category);

    Optional<Result> findByIdAndUserId(Long id, Long userId);

    @Query("SELECT AVG(r.score) FROM Result r WHERE r.user.id = :userId")
    Double findAverageScoreByUserId(Long userId);

    @Query("SELECT COUNT(r) FROM Result r WHERE r.user.id = :userId AND r.score >= 80")
    Long countHighScoresByUserId(Long userId);

    long countByUserId(Long userId);
}
