/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cvgenerator.servicio;

import com.cvgenerator.entidades.FormAcad;
import com.cvgenerator.entidades.Persona;
import com.cvgenerator.repositorio.AcademicoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rocio
 */
@Service
public class AcademicoServicio {
    @Autowired
    private AcademicoRepositorio academicoRepositorio;
    
    public FormAcad guardar(FormAcad academico){
        return academicoRepositorio.save(academico);
    }
    
    public List<FormAcad> findTitulosByPersona(Persona persona){
        List<FormAcad> titulos = academicoRepositorio.findTitulosByPersona(persona);
        return titulos;
    } 
}
