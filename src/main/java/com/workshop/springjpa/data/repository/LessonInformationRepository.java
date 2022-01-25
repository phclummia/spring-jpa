package com.workshop.springjpa.data.repository;

import com.workshop.springjpa.data.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface LessonInformationRepository extends JpaRepository<LessonInformationEntity, Long> {
}
