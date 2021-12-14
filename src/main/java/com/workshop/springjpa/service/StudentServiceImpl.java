package com.workshop.springjpa.service;


import com.workshop.springjpa.data.model.*;
import com.workshop.springjpa.data.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.math.*;
import java.util.*;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentInformationRepository repository;

    @Override
    public List<StudentInformationEntity> get() {
        return repository.findAll();
    }

    @Override
    public StudentInformationEntity get(Long id) {
        return repository.getById(id);
    }

    @Override
    public StudentInformationEntity findByMailAddress(String mailAddress) {
        return repository.findByMailAddress(mailAddress).orElse(null);
    }

    @Override
    public StudentInformationEntity create(StudentInformationEntity current) {
        return repository.saveAndFlush(current);
    }

    @Override
    public StudentInformationEntity update(Long id, StudentInformationEntity current) {
        return repository.saveAndFlush(StudentInformationEntity.builder()
                .name(current.getName())
                .mailAddress(current.getMailAddress())
                .surname(current.getSurname())
                .id(id)
                .studentParentEntity(current.getStudentParentEntity())
                .lessonInformationEntityList(current.getLessonInformationEntityList())
                .build());
    }

    @Override
    public BigInteger getCount() {
        BigInteger count = BigInteger.valueOf(repository.count());

        return count;
    }

    @Override
    public Map<String, List<StudentInformationEntity>> getStudentsSortedLists() {
        Map<String, List<StudentInformationEntity>> map = new HashMap<>();

        map.put("ASC", repository.findByOrderBySurnameAsc());
        map.put("DESC", repository.findByOrderBySurnameDesc());
        return map;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
        return;
    }
}
