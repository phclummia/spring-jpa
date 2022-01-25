package com.workshop.springjpa.data.model;


import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity(name = "LessonInformationEntity")
@Table(name = "lesson_information_entity")
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LessonInformationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 80)
    private String name;
    @Column(name = "weekly_hour", nullable = false, length = 80)
    private Integer weeklyHour;
    @Column(name = "teacher_name", nullable = false, length = 160)
    private String teacherName;

    @ManyToMany(mappedBy = "lessonInformationEntityList", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnore
    private List<StudentInformationEntity> studentInformation;


}
