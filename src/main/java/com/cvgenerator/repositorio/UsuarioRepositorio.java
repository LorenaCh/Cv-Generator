package com.cvgenerator.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cvgenerator.entidades.Usuario;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

        
	public Usuario findByEmail(String email);
	boolean existsByEmail(String email);
}
