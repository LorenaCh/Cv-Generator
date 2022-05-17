/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvgenerator.servicio;

import com.cvgenerator.entidades.Persona;
import com.cvgenerator.entidades.Usuario;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cvgenerator.repositorio.PersonaReposotorio;
import java.util.ArrayList;

/**
 *
 * @author barby
 */
@Service
public class PersonaServicio {
    
      @Autowired
    private PersonaReposotorio repPersona;
    
@Transactional
    public Persona guardar(Usuario usuario){
        Persona persona = new Persona();
        persona.setUsuario(usuario);
        return repPersona.save(persona);
    }
    
    public Persona crear(){
        return new Persona();
    }
    
    public void eliminar(Persona persona){
       repPersona.delete(persona);
    }
    
    @Transactional(readOnly=true)
    public Persona findById(Long id){
        return repPersona.findById(id).orElse(null);
    }
    
    @Transactional(readOnly=true)
    public List<Persona> findAll(){
        return repPersona.findAll();
    }
    
    
    
    public Persona guardar(Persona persona){
        return repPersona.save(persona);
    }
    
    
}
