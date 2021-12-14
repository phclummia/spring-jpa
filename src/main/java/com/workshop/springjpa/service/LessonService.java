package com.workshop.springjpa.service;


import com.workshop.springjpa.data.model.*;

import java.util.*;

public interface LessonService {

    List<LessonInformationEntity> get();

    LessonInformationEntity get(Long id);


    LessonInformationEntity create(LessonInformationEntity current);

    LessonInformationEntity update(Long id, LessonInformationEntity current);

    void delete(Long id);


}
