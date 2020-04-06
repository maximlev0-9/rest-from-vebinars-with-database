package ua.lviv.iot.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.data.SubjectRepository;
import ua.lviv.iot.rest.RestAplication.model.Student;
import ua.lviv.iot.rest.RestAplication.model.Subject;

import java.util.List;


@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

//    public ResponseEntity<Subject> getSubject(int id){
//        return ResponseEntity.status(HttpStatus.OK).body(subjectRepository.getOne(id));
//    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public ResponseEntity<Student> deleteSubject(int id){
        subjectRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
