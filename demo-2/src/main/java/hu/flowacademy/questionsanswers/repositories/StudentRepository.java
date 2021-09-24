package hu.flowacademy.questionsanswers.repositories;

import hu.flowacademy.questionsanswers.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
