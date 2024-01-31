package com.project.project.service.services;

import com.project.project.model.Resumen;
import com.project.project.service.repositories.ResumenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumenService {
    @Autowired
    private ResumenRepository resumenRepository;

    public void addUpdate(Resumen resumen) {
        resumenRepository.save(resumen);
    }

    public List<Resumen> findAll() {
        return resumenRepository.findAll();
    }

    public Resumen findById(Integer id) {
        return resumenRepository.findById(id).orElse(new Resumen());
    }

    public void deleteById(Integer id) {
        resumenRepository.deleteById(id);
    }
}
