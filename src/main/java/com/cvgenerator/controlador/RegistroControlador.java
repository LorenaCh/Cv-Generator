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
        
        @GetMapping("/home")
        public String index(){
            return "index";
        }
	
	@GetMapping("/")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("usuarios", servicio.listarUsuarios());
		return "bienvenida";
	}
        
        
        @GetMapping("/cvpersonal")
        public String cv_personal(){
            return "/plantillascv/formulario";
        }
        
        @GetMapping("/plantillacv")
        public String plantilla(){
            return "/plantillascv/p1";
        }
        
        @GetMapping("/formulario")
        public String formulario(){
            return "formulario";
        }
        
        @GetMapping("/consejos")
        public String consejo(){
            return "consejos";
        }

}
