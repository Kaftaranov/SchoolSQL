package ru.hogwarts.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.Models.Faculty;
import ru.hogwarts.school.Repository.FacultyRepository;

import java.util.*;

@Service
public class FacultyService {
    private  final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty add(Faculty faculty){
        return facultyRepository.save(faculty);
    }
    public Faculty findById(long id){
        return facultyRepository.findById(id);
    }
    public List<Faculty> filterByColorOrName(String descriptor) {
       /* if (facultyRepository.findFacultiesByColorIgnoreCase(descriptor) != null){
            return facultyRepository.findFacultiesByColorIgnoreCase(descriptor);
        }
        if (facultyRepository.findFacultiesByNameIgnoreCase(descriptor) != null){
            return facultyRepository.findFacultiesByNameIgnoreCase(descriptor);
        }
        return null;*/
        return facultyRepository.findFacultyByNameIgnoreCaseOrColorIgnoreCase(descriptor,descriptor);
    }

    public Faculty update(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public void remove(long id){
        facultyRepository.deleteById(id);
    }
    public List<Faculty> getAll(){return facultyRepository.findAll();}

}

