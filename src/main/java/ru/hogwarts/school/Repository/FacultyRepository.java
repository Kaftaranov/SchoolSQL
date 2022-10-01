package ru.hogwarts.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.Models.Faculty;
import ru.hogwarts.school.Models.Student;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findFacultiesByNameIgnoreCase(String name);
    Faculty findFacultiesByColorIgnoreCase(String color);
    Faculty findById(long id);
}
