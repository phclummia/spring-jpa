package com.workshop.springjpa.controller;


import com.workshop.springjpa.data.model.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Validated
@RequestMapping(value = "/api/v1/student")
public interface StudentController {


    @RequestMapping(method = RequestMethod.GET)
    List<StudentInformationEntity> get();


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    StudentInformationEntity get(@PathVariable Long id);

    @RequestMapping(value = "/mail", method = RequestMethod.GET)
    StudentInformationEntity getByName(@RequestParam String mailAddress);


    @RequestMapping(method = RequestMethod.POST)
    StudentInformationEntity create(@RequestBody StudentInformationEntity stockDto);


    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    StudentInformationEntity update(@PathVariable("id") Long id,
                      @RequestBody StudentInformationEntity stockDto);


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") Long id);

}
