package com.aiinterview.config;

import com.aiinterview.entity.Question;
import com.aiinterview.entity.Question.Category;
import com.aiinterview.entity.Question.Difficulty;
import com.aiinterview.repository.QuestionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final QuestionRepository questionRepository;

    private static final Logger log =
            LoggerFactory.getLogger(DataSeeder.class);

    public DataSeeder(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void run(String... args) {

        if (questionRepository.count() > 0) {
            log.info("Questions already seeded, skipping.");
            return;
        }

        List<Question> questions = new ArrayList<>();

        Question q1 = new Question();
        q1.setContent("What is the difference between an interface and an abstract class in Java?");
        q1.setCategory(Category.JAVA);
        q1.setDifficulty(Difficulty.EASY);
        q1.setExpectedAnswer("Interfaces define contracts while abstract classes can contain state and implemented methods.");
        q1.setFollowUpHint("When would you choose one over the other?");
        questions.add(q1);

        Question q2 = new Question();
        q2.setContent("Explain the Java Memory Model and difference between heap and stack.");
        q2.setCategory(Category.JAVA);
        q2.setDifficulty(Difficulty.MEDIUM);
        q2.setExpectedAnswer("Stack stores method calls and local variables, heap stores objects.");
        questions.add(q2);

        Question q3 = new Question();
        q3.setContent("Explain the Spring Bean lifecycle.");
        q3.setCategory(Category.SPRING);
        q3.setDifficulty(Difficulty.MEDIUM);
        q3.setExpectedAnswer("Instantiation → Dependency Injection → Initialization → Ready → Destruction.");
        questions.add(q3);

        Question q4 = new Question();
        q4.setContent("Explain ACID properties.");
        q4.setCategory(Category.DATABASE);
        q4.setDifficulty(Difficulty.EASY);
        q4.setExpectedAnswer("Atomicity, Consistency, Isolation, Durability.");
        questions.add(q4);

        Question q5 = new Question();
        q5.setContent("Explain stack vs queue.");
        q5.setCategory(Category.DATA_STRUCTURES);
        q5.setDifficulty(Difficulty.EASY);
        q5.setExpectedAnswer("Stack = LIFO, Queue = FIFO.");
        questions.add(q5);

        questionRepository.saveAll(questions);

        log.info("Seeded {} questions successfully.", questions.size());
    }
}