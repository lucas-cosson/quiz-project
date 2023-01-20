package lapireteam.quizzle.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import lapireteam.quizzle.entity.Quiz;
import lapireteam.quizzle.entity.User;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> getByUser(User user, Sort sort);
}
