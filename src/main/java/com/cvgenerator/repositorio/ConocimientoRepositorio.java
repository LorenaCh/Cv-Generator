package com.cvgenerator.repositorio;

import com.cvgenerator.entidades.Conocimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConocimientoRepositorio extends JpaRepository<Conocimiento, Integer> {
    
}
