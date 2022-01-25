package com.workshop.springjpa.service;


import com.workshop.springjpa.data.model.*;

import java.math.*;
import java.util.*;

public interface StudentService {

    List<StudentInformationEntity> get();

    StudentInformationEntity get(Long id);

    StudentInformationEntity findByMailAddress(String mailAddress);

    StudentInformationEntity create(StudentInformationEntity current);

    StudentInformationEntity update(Long id, StudentInformationEntity current);

    void delete(Long id);

    BigInteger getCount();

    Map<String, List<StudentInformationEntity>> getStudentsSortedLists();


}
