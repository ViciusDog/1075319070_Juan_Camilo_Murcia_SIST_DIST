package com.project.project.service.services;

import com.project.project.model.Person;
import com.project.project.model.Registro;
import com.project.project.service.repositories.PersonRepository;
import com.project.project.service.repositories.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroService {
    @Autowired
    private RegisterRepository registerRepository;

    public void addUpdate(Registro registro) {
        registerRepository.save(registro);
    }

    public List<Registro> findAll() {
        return registerRepository.findAll();
    }

    public Registro findById(Integer id) {
        return registerRepository.findById(id).orElse(new Registro());
    }

}
