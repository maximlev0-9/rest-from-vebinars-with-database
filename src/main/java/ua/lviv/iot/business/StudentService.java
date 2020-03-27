package ua.lviv.iot.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.data.StudentRepository;
import ua.lviv.iot.rest.RestAplication.model.Student;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {

        return studentRepository.save(student);
    }
}
