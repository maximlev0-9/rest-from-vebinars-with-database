package ua.lviv.iot.rest.RestAplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.business.SubjectService;
import ua.lviv.iot.rest.RestAplication.model.Student;
import ua.lviv.iot.rest.RestAplication.model.Subject;

@RequestMapping("/subjects")
@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<Subject> getSubjects() {
        return subjectService.getAllSubjects();
    }



    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public Subject createSubject(final @RequestBody Subject subject) {
        return subjectService.createSubject(subject);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Student> deleteSubject(@PathVariable("id") Integer subjectId) {
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
