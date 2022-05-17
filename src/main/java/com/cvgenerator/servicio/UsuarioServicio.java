package com.cvgenerator.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.cvgenerator.controlador.dto.UsuarioRegistroDTO;
import com.cvgenerator.entidades.Persona;
import com.cvgenerator.entidades.Usuario;
import java.util.Optional;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
        
        public boolean existeEmail(String email);
	
        public Optional<Usuario> findById(Long id);
        
        public Usuario guardar(Usuario usuario);
        
        public Usuario findByEmail(String email);
        
        public Persona findPersonaByUsername(String username);
}
