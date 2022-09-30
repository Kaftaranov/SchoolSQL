package ru.hogwarts.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.Models.Student;
import java.util.List;

public interface StudentsRepository extends JpaRepository<Student, Long> {
    List<Student> findByAge(int age);
    List<Student> findByAgeBetween(int min, int max);
    List<Student> findAllByNameContainingIgnoreCase(String letter);
    Student findById(long id);
}
