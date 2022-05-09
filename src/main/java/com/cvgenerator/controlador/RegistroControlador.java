package com.cvgenerator.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cvgenerator.servicio.UsuarioServicio;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistroControlador {

	@Autowired
	private UsuarioServicio servicio;
	
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
	
	@GetMapping("/")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("usuarios", servicio.listarUsuarios());
		return "bienvenida";
	}
        
        
}
