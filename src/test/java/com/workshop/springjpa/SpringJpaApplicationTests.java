package com.workshop.springjpa;

import com.workshop.springjpa.data.model.*;
import com.workshop.springjpa.service.*;
import lombok.extern.log4j.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import java.util.*;

@SpringBootTest
@Log4j2
class SpringJpaApplicationTests {

    @Autowired
    StudentService studentService;
    @Autowired
    StudentParentService studentParentService;
    @Autowired
    LessonService lessonService;



    @Test
    void testSorting() {
        log.error("--------------------------------------");
        log.error("testSorting");

        Map<String,List<StudentInformationEntity>> map = studentService.getStudentsSortedLists();

        log.error("Ascending List By Surname Start");
        for(StudentInformationEntity item : map.get("ASC")){
            log.error("Name : {}, Surname : {}",item.getName(),item.getSurname());
        }
        log.error("Ascending List By Surname End");

        log.error("Descending List By Surname Start");
        for(StudentInformationEntity item : map.get("DESC")){
            log.error("Name : {}, Surname : {}",item.getName(),item.getSurname());
        }
        log.error("Descending List By Surname End");

        log.error("--------------------------------------");
    }



    @Test
    void testCount() {
        log.error("--------------------------------------");
        log.error("testCount");
        log.error("Count : {}", studentService.getCount());
        log.error("--------------------------------------");
    }

    @Test
    void contextLoads() {


        // One to One Insert - Insert - Update Relation
        StudentInformationEntity createdUser = studentService.create(StudentInformationEntity.builder()
                .mailAddress("student@mail.com")
                .name("John")
                .surname("Deer")
                .build());

        StudentInformationEntity createdUserMany = studentService.create(StudentInformationEntity.builder()
                .mailAddress("studentmany@mail.com")
                .name("Second Student")
                .surname("Many")
                .build());

        StudentParentEntity createdParent = studentParentService.create(StudentParentEntity.builder()
                .mailAddress("parent@mail.com")
                .name("Parent Name")
                .surname("Parent Surname")
                .studentInformation(createdUser)
                .build());

        createdUser.setStudentParentEntity(createdParent);
        studentService.update(createdUser.getId(), createdUser);

        // One to One Instert - Insert - Update Relation

        // Many to Many

        LessonInformationEntity lesson1 = lessonService.create(LessonInformationEntity.builder()
                .name("Math")
                .teacherName("Danyal Topatan")
                .weeklyHour(5)
                .build());

        LessonInformationEntity lesson2 = lessonService.create(LessonInformationEntity.builder()
                .name("Music")
                .teacherName("Nebahat Gülses")
                .weeklyHour(5)
                .build());


        List<LessonInformationEntity> lessonList = new ArrayList<>();
        lessonList.add(lesson1);
        lessonList.add(lesson2);

        createdUser.setLessonInformationEntityList(lessonList);
        createdUserMany.setLessonInformationEntityList(lessonList);
        studentService.update(createdUser.getId(), createdUser);
        studentService.update(createdUserMany.getId(), createdUserMany);


        log.warn("--------------------------------------");
        for (StudentInformationEntity student : studentService.get()) {
            log.warn("Student : " + student.getName());

            for (LessonInformationEntity lesson : student.getLessonInformationEntityList()) {
                log.warn("Lesson Name : " + lesson.getName());
            }
        }

        for (LessonInformationEntity lesson : lessonService.get()) {
            log.warn("Lesson : " + lesson.getName());

            for (StudentInformationEntity student : lesson.getStudentInformation()) {
                log.warn("Student Name : " + student.getName());
            }
        }


        log.warn("--------------------------------------");


        // Many to Many
    }

}
