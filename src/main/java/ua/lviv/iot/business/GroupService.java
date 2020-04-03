package ua.lviv.iot.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.data.GroupRepository;
import ua.lviv.iot.rest.RestAplication.model.Group;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository repository;

    public List<Group> getAllGroups() {
        return repository.findAll();
    }

    public Group addGroup(Group group){
        return repository.save(group);
    }
}
