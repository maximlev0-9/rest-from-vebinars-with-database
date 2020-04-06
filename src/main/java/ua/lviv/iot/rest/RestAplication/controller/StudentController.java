package ua.lviv.iot.rest.RestAplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.business.StudentService;
import ua.lviv.iot.rest.RestAplication.model.Student;

@RequestMapping("/students")
@RestController
public class StudentController {
    static private Map<Integer, Student> students = new HashMap<>();
    static private AtomicInteger idCounter = new AtomicInteger();
    @Autowired
    private StudentService studentService;
//
//    @GetMapping
//    public List<Student> getStudents() {
//        return studentService.getAllStudents();
//    }

    @GetMapping
    public List<Student> getStudents(final @RequestParam(name = "firstName", required = false) String firstName) {
        if (firstName == null) {
            return studentService.getAllStudents();
        }
        return studentService.getAllByName(firstName);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> getStudent(final @PathVariable("id") Integer studentId) {
//        return students.get(studentId);
        return studentService.getStudent(studentId);
    }


    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public Student createStudent(final @RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Integer studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping(path = "/{id}")
    public Student updateStudent(final @PathVariable("id") Integer studentId, final @RequestBody Student student) {
        student.setId(studentId);

        return students.put(studentId, student);
    }
}
