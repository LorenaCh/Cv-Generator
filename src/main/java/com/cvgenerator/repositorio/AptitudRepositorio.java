/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cvgenerator.repositorio;

import com.cvgenerator.entidades.Aptitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rocio
 */
@Repository
public interface AptitudRepositorio extends JpaRepository<Aptitud,Integer>{
    
}
