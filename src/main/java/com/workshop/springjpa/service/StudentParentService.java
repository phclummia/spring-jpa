package com.workshop.springjpa.service;


import com.workshop.springjpa.data.model.*;

import java.util.*;

public interface StudentParentService {

    List<StudentParentEntity> get();

    StudentParentEntity get(Long id);

    StudentParentEntity findByMailAddress(String mailAddress);

    StudentParentEntity create(StudentParentEntity current);

    StudentParentEntity update(Long id, StudentParentEntity current);

    void delete(Long id);


}
