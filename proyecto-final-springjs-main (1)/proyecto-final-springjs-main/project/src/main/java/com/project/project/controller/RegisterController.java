package com.project.project.controller;

import com.project.project.model.Person;
import com.project.project.model.Registro;
import com.project.project.model.Resumen;
import com.project.project.service.services.PersonService;
import com.project.project.service.services.RegistroService;
import com.project.project.service.services.ResumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person-data")
@CrossOrigin("*")
public class RegisterController {
    @Autowired private RegistroService resumenService;
    @Autowired private PersonService personService;

    @PostMapping(path = "/{id}/newRecord", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createRecord(@PathVariable Integer id, @RequestBody Registro record) {
        record.setPersona(personService.findById(id));
        resumenService.addUpdate(record);
    }

    @GetMapping(path = "/records/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Registro obtenerResumenes(@PathVariable Integer id) {
        return resumenService.findById(id);
    }

}
