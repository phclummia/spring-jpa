package com.workshop.springjpa.service;


import com.workshop.springjpa.data.model.*;
import com.workshop.springjpa.data.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class StudentParentServiceImpl implements StudentParentService {

    private final StudentParentRepository repository;

    @Override
    public List<StudentParentEntity> get() {
        return repository.findAll();
    }

    @Override
    public StudentParentEntity get(Long id) {
        return repository.getById(id);
    }

    @Override
    public StudentParentEntity findByMailAddress(String mailAddress) {
        return repository.findByMailAddress(mailAddress).orElse(null);
    }

    @Override
    public StudentParentEntity create(StudentParentEntity current) {
        return repository.saveAndFlush(current);
    }

    @Override
    public StudentParentEntity update(Long id, StudentParentEntity current) {
        return repository.saveAndFlush(StudentParentEntity.builder()
                .name(current.getName())
                .mailAddress(current.getMailAddress())
                .surname(current.getSurname())
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
