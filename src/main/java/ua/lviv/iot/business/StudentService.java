package ua.lviv.iot.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.data.StudentRepository;
import ua.lviv.iot.rest.RestAplication.model.Student;

import java.util.List;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {

        return studentRepository.save(student);
    }

    public ResponseEntity<Student> getStudent(int id){
        return ResponseEntity.status(HttpStatus.OK).body(studentRepository.getOne(id));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public ResponseEntity<Student> deleteStudent(int id){
        studentRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
