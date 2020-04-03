package ua.lviv.iot.rest.RestAplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.business.GroupService;
import ua.lviv.iot.rest.RestAplication.model.Group;

import java.util.List;

@RequestMapping("/groups")
@RestController
public class GroupController {
    @Autowired
    private GroupService service;

    @GetMapping
    public List<Group> getAllGroups(){
        return service.getAllGroups();
    }
}
