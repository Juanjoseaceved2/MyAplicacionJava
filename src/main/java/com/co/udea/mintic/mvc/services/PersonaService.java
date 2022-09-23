package com.co.udea.mintic.mvc.services;


import com.co.udea.mintic.mvc.entities.Persona;
import com.co.udea.mintic.mvc.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    //Creación de objetos
    private PersonaRepository repository;
    //Creación de objetos


    //Constructor
    public PersonaService(PersonaRepository repository){
        this.repository = repository;
    }
    //Constructor


    public List<Persona> getLstPersonas() {
        return this.repository.findAll();
    }

    public Persona crearPersona(Persona unaPersona){
        return this.repository.save(unaPersona);
    }

    public Boolean borrarPersona(Long id) {
        this.repository.deleteById(id);
        return true;
    }
}
