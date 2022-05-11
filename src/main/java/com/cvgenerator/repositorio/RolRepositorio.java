package com.cvgenerator.repositorio;

import com.cvgenerator.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Long>{
    @Query("SELECT r FROM Rol r WHERE r.nombre = :nombre")
    public Rol findByNombre(@Param("nombre")String nombre);
}
