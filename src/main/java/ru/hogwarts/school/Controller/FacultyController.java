package ru.hogwarts.school.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.Models.Faculty;
import ru.hogwarts.school.Models.Student;
import ru.hogwarts.school.Service.FacultyService;
import ru.hogwarts.school.Service.StudentService;

import java.util.List;

@RestController
@RequestMapping(path = "/faculty")
public class FacultyController {
    private final FacultyService facultyService;
    private final StudentService studentService;
    public FacultyController(FacultyService facultyService, StudentService studentService){
        this.facultyService = facultyService;
        this.studentService = studentService;
    }
    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFaculty (@PathVariable long id){
        Faculty faculty = facultyService.findById(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @GetMapping("/find")
    public ResponseEntity<List<Faculty>> filterByColorOrName(@RequestParam String descriptor){
        List<Faculty> faculty = facultyService.filterByColorOrName(descriptor);
        if (faculty == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Faculty>> getAllFaculties(){
        return ResponseEntity.ok(facultyService.getAll());
    }
    @GetMapping("/{id}/students")
    public ResponseEntity<List<Student>> getStudentsOfFaculty(long faculty){
        return ResponseEntity.ok(studentService.getStudentsOfFaculty(faculty));
    }

    @PostMapping("/add")
    public Faculty add(@RequestBody Faculty faculty){
        return  facultyService.add(faculty);
    }

    @PutMapping("/update")
    public ResponseEntity<Faculty> update(@RequestBody Faculty faculty){
        Faculty updatedfaculty = facultyService.update(faculty);
        if (updatedfaculty == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedfaculty);
    }

    @DeleteMapping ("{id}")
    public ResponseEntity remove(@PathVariable long id){
        facultyService.remove(id);
        return ResponseEntity.ok().build();
    }

}

