/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cvgenerator.servicio;

import com.cvgenerator.entidades.Conocimiento;
import com.cvgenerator.repositorio.ConocimientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rocio
 */

@Service
public class ConocimientoServicio {
    @Autowired
    private ConocimientoRepositorio conoRepositorio;
    
    @Transactional
    public Conocimiento guardar(Conocimiento conocimiento){
        return conoRepositorio.save(conocimiento);
    }
}
