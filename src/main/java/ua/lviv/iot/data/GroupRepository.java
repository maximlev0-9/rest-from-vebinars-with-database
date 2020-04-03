package ua.lviv.iot.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.rest.RestAplication.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
}
