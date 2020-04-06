package ua.lviv.iot.data;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.rest.RestAplication.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
