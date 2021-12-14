package com.workshop.springjpa.controller;

import com.workshop.springjpa.data.model.*;
import com.workshop.springjpa.service.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class StudentControllerImpl implements StudentController {

    private final StudentService service;

    @Override
    public List<StudentInformationEntity> get() {
        return service.get();
    }

    @Override
    public StudentInformationEntity get(Long id) {
        return service.get(id);
    }

    @Override
    public StudentInformationEntity getByName(String mailAddress) {
        return service.findByMailAddress(mailAddress);
    }

    @Override
    public StudentInformationEntity create(StudentInformationEntity studentDto) {
        return service.create(studentDto);
    }

    @Override
    public StudentInformationEntity update(Long id, StudentInformationEntity stockDto) {
        return service.update(id, stockDto);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
