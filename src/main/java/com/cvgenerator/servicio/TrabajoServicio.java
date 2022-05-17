/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cvgenerator.servicio;

import com.cvgenerator.entidades.Persona;
import com.cvgenerator.entidades.Trabajo;
import com.cvgenerator.repositorio.TrabajoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rocio
 */
@Service
public class TrabajoServicio {
    
    @Autowired
    private TrabajoRepositorio trabRepositorio;
    
    @Transactional
    public Trabajo guardar(Trabajo trabajo){
        return trabRepositorio.save(trabajo);
    }
    
    public List<Trabajo> findTrabajosByPersona(Persona persona){
        List<Trabajo> trabajos = trabRepositorio.findTrabajosByPersona(persona);
        return trabajos;
    }
    
    public void eliminar(Trabajo trabajo){
        trabRepositorio.delete(trabajo);
        
    }
}
