package com.lapireteam.quizzproject.repository;

import com.lapireteam.quizzproject.entity.SimpleQuiz;
import com.lapireteam.quizzproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SimpleQuizRepository extends JpaRepository<SimpleQuiz, Long> {
    Optional<SimpleQuiz> findByAuthor(User user);
}
