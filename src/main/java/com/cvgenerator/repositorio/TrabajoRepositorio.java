/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cvgenerator.repositorio;

import com.cvgenerator.entidades.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rocio
 */
@Repository
public interface TrabajoRepositorio extends JpaRepository<Trabajo, Integer>{
    
}
