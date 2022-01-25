package com.workshop.springjpa.data.repository;

import com.workshop.springjpa.data.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface StudentInformationRepository extends JpaRepository<StudentInformationEntity, Long> {
    Optional<StudentInformationEntity> findByName(String username);

    Optional<StudentInformationEntity> findBySurname(String surname);

    Optional<StudentInformationEntity> findByMailAddress(String emailAddress);

    List<StudentInformationEntity> findByOrderBySurnameAsc();
    List<StudentInformationEntity> findByOrderBySurnameDesc();
}
