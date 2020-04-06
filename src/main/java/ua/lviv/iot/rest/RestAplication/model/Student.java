package ua.lviv.iot.rest.RestAplication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Student {
    private String firstName;
    private String lastName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="group_id")
    @JsonIgnoreProperties("students")
    private Group group;
    @ManyToMany(mappedBy = "students")
    @JsonIgnoreProperties("students")
    private Set<Subject> subjects;


}
