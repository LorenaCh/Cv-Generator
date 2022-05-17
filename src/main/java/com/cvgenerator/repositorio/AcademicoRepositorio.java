/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cvgenerator.repositorio;

import com.cvgenerator.entidades.FormAcad;
import com.cvgenerator.entidades.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rocio
 */
@Repository
public interface AcademicoRepositorio extends JpaRepository<FormAcad, Integer>{
    
    public List<FormAcad> findTitulosByPersona(Persona persona);
}
