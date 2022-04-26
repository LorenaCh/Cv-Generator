package com.cvgenerator.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.cvgenerator.controlador.dto.UsuarioRegistroDTO;
import com.cvgenerator.entidades.Usuario;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
        
        public boolean existeEmail(String email);
	
}
