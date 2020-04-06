package ua.lviv.iot.data;

import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.rest.RestAplication.model.Student;

import java.util.List;

@Repository
@NamedNativeQuery(name = "Student.findBestStudent",
        query = "select * from students where id = 1")
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByFirstName(String firstName);
}
