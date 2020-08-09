package com.codemcd.springcustomvalidation.controller;

import com.codemcd.springcustomvalidation.dto.PersonDto;
import com.codemcd.springcustomvalidation.support.CustomCollectionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DoorController {

    @Autowired
    private CustomCollectionValidator validator;

    @PostMapping("/person")
    public Boolean comeOne(@RequestBody @Valid PersonDto personDto) {
        System.out.println(personDto);

        return true;
    }

    @PostMapping("/people")
    public Boolean come(@RequestBody @Valid List<PersonDto> peopleDto, Errors errors) {
        validator.validate(peopleDto, errors);

        return true;
    }
}
