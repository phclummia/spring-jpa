package com.workshop.springjpa.data.repository;

import com.workshop.springjpa.data.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface StudentParentRepository extends JpaRepository<StudentParentEntity, Long> {
    Optional<StudentParentEntity> findByName(String username);

    Optional<StudentParentEntity> findBySurname(String surname);

    Optional<StudentParentEntity> findByMailAddress(String emailAddress);
}
