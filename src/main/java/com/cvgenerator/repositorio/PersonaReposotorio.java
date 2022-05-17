/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvgenerator.repositorio;

import com.cvgenerator.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author barby
 */

  @Repository
public interface PersonaReposotorio extends JpaRepository<Persona, Long>{      
}