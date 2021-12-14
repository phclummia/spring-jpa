package com.workshop.springjpa.service;


import com.workshop.springjpa.data.model.*;
import com.workshop.springjpa.data.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonInformationRepository repository;

    @Override
    public List<LessonInformationEntity> get() {
        return repository.findAll();
    }

    @Override
    public LessonInformationEntity get(Long id) {
        return repository.getById(id);
    }


    @Override
    public LessonInformationEntity create(LessonInformationEntity current) {
        return repository.saveAndFlush(current);
    }

    @Override
    public LessonInformationEntity update(Long id, LessonInformationEntity current) {
        return repository.saveAndFlush(LessonInformationEntity.builder()
                .name(current.getName())
                .teacherName(current.getTeacherName())
                .weeklyHour(current.getWeeklyHour())
                .id(id)
                .studentInformation(current.getStudentInformation())
                .build());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
        return;
    }
}
