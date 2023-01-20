package lapireteam.quizzle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lapireteam.quizzle.entity.Subject;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Subject getSubjectBySubjectCode(String subjectCode);
    List<Subject> findAll();

}
