package com.workshop.springjpa.data.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity(name = "StudentInformationEntity")
@Table(name = "student_information_entity")
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentInformationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 80)
    private String name;
    @Column(name = "surname", nullable = false, length = 80)
    private String surname;
    @Column(name = "mail_address", nullable = false, length = 160)
    private String mailAddress;

    @OneToOne
    private StudentParentEntity studentParentEntity;

    @ManyToMany(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "student_lessons",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    private List<LessonInformationEntity> lessonInformationEntityList;
}
