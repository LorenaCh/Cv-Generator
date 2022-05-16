/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cvgenerator.servicio;

import com.cvgenerator.entidades.Aptitud;
import com.cvgenerator.repositorio.AptitudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rocio
 */
@Service
public class AptitudServicio {
    @Autowired
    private AptitudRepositorio aptRepositorio;
    
    @Transactional
    public Aptitud guarda(Aptitud apt){
        return aptRepositorio.save(apt);
    }
}
