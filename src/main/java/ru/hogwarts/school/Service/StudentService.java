package ru.hogwarts.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.Models.Faculty;
import ru.hogwarts.school.Models.Student;
import ru.hogwarts.school.Repository.StudentsRepository;
import ru.hogwarts.school.Repository.FacultyRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentsRepository studentsRepository;
    private final FacultyRepository facultyRepository;

    public StudentService(StudentsRepository studentsRepository, FacultyRepository facultyRepository) {
        this.studentsRepository = studentsRepository;
        this.facultyRepository = facultyRepository;
    }

    public Student add(Student student) {
        return studentsRepository.save(student);
    }
    public Student findById(long id) {
        return studentsRepository.findById(id);
    }
    public List<Student> filterByAge(int age) {
        List<Student> filteredByAge = new ArrayList<>(studentsRepository.findByAge(age)) ;
        return filteredByAge.stream()
                .filter(student ->student.getAge()==age)
                .collect(Collectors.toList());
    }
    public Student update(Student student) {
        return studentsRepository.save(student);
    }
    public void remove(long id) {
        studentsRepository.deleteById(id);
    }
    public List<Student>getAll(){
        return studentsRepository.findAll();
    }

    public List<Student> findByAgeBetween(int min_age, int max_age) {
        return studentsRepository.findByAgeBetween(min_age,max_age);
        }
    public List<Student> findAllByNameContaining(String letter){
        return studentsRepository.findAllByNameContainingIgnoreCase(letter);
    }

    public List<Student> getStudentsOfFaculty(long faculty_id) {
        return studentsRepository.findStudentByFaculty_IdOrderByName(faculty_id);
    }

    public Faculty getfacultyOfStudent(long id) {
      return
      facultyRepository.findById(studentsRepository.findById(id).getFacultyId()) ;
    }
}


