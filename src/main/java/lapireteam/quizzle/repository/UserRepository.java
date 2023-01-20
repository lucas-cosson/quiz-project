package lapireteam.quizzle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lapireteam.quizzle.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
