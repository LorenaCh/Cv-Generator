package com.cvgenerator.controlador;

import com.cvgenerator.entidades.Persona;
import com.cvgenerator.entidades.Usuario;
import com.cvgenerator.servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cvgenerator.servicio.UsuarioServicio;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistroControlador {

	@Autowired
	private UsuarioServicio servicio;
        
        @Autowired
        private PersonaServicio personaServicio;
	
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
        
        @PostMapping("/guardarPerfil")
        public String guardarPerfil(@RequestParam String mailUsuario,Persona persona,Model model){ 
            Usuario usuario = servicio.findByEmail(mailUsuario);
            persona.setIdPersona(usuario.getPersona().getIdPersona());
            personaServicio.guardar(persona);
            model.addAttribute("persona",persona);
            return "formulario";
        }
        
        @PostMapping("/guardarResumen")
        public String guardarResumen(@RequestParam String mailUsuario,Persona persona,Model model){ 
            Usuario usuario = servicio.findByEmail(mailUsuario);
            Persona personaActual = personaServicio.findById(usuario.getPersona().getIdPersona());
            personaActual.setDescripcion(persona.getDescripcion());
            personaServicio.guardar(personaActual);
            model.addAttribute("persona",personaActual);
            return "formulario";
        }
}
