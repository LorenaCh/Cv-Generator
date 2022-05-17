package com.cvgenerator.controlador;

import com.cvgenerator.entidades.FormAcad;
import com.cvgenerator.entidades.Persona;
import com.cvgenerator.entidades.Trabajo;
import com.cvgenerator.entidades.Usuario;
import com.cvgenerator.servicio.AcademicoServicio;
import com.cvgenerator.servicio.PersonaServicio;
import com.cvgenerator.servicio.TrabajoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cvgenerator.servicio.UsuarioServicio;
import java.util.ArrayList;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import org.springframework.data.repository.query.Param;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistroControlador {

    @Autowired
    private UsuarioServicio servicio;

    @Autowired
    private PersonaServicio personaServicio;
    
    @Autowired
    private TrabajoServicio trabajoServicio;
    
    @Autowired
    private AcademicoServicio academicoServicio;
    
    private Persona persona;

    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    @GetMapping("/home")
    public String index() {
        return "index";
    }

    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo) {
        modelo.addAttribute("usuarios", servicio.listarUsuarios());
        return "bienvenida";
    }

    @GetMapping("/cvpersonal")
    public String cv_personal() {
        return "/plantillascv/formulario";
    }

    @GetMapping("/plantillacv")
    public String plantilla() {
        return "/plantillascv/p1";
    }

    @GetMapping("/formulario")
    public String formulario(HttpSession session, Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        this.persona = servicio.findPersonaByUsername(username);
        
        model.addAttribute("persona",persona);
        
        ArrayList<Trabajo> trabajos = (ArrayList<Trabajo>) trabajoServicio.findTrabajosByPersona(persona);
        model.addAttribute("trabajos",trabajos);
        return "formulario";
    }

    @GetMapping("/consejos")
    public String consejo() {
        return "consejos";
    }

    @PostMapping("/guardarPerfil")
    public String guardarPerfil(Persona personaE, Model model) {
        this.persona.setNombre(personaE.getNombre());
        this.persona.setApellido(personaE.getApellido());
        this.persona.setDireccion(personaE.getDireccion());
        this.persona.setCiudad(personaE.getCiudad());
        this.persona.setNacionalidad(personaE.getNacionalidad());
        this.persona.setCorreo(personaE.getCorreo());
        this.persona.setTelefono(personaE.getTelefono());
        this.persona.setEdad(personaE.getEdad());
        this.persona.setProfesion(personaE.getProfesion());
        personaServicio.guardar(persona);
        model.addAttribute("persona", persona);
        return "formulario";
    }

    @PostMapping("/guardarResumen")
    public String guardarResumen(@RequestParam String descripcion, Model model) {
        this.persona.setDescripcion(descripcion);
        personaServicio.guardar(this.persona);
        model.addAttribute("persona", persona);
        return "formulario";
    }
    
    @PostMapping("/guardarLaboral")
    public String guardarLaboral(@RequestParam String username,@RequestParam String puesto,@RequestParam String lugar,@RequestParam(required = false) Integer desde,@RequestParam(required = false) Integer hasta,@RequestParam Boolean activo,Model model){
        
        Usuario usuario = servicio.findByEmail(username);
        
        Persona personaE = personaServicio.findById(usuario.getId());
        personaE.setIdPersona(usuario.getPersona().getIdPersona());
        
        Trabajo trabajo = new Trabajo();
        trabajo.setPuesto(puesto);
        trabajo.setLugar(lugar);
        trabajo.setDesde(desde);
        trabajo.setHasta(hasta);
        System.out.println(activo);
        trabajo.setActivo(activo);
        
        
        trabajo.setPersona(personaE);
        
        trabajoServicio.guardar(trabajo);
        
        ArrayList<Trabajo> trabajos = (ArrayList<Trabajo>) trabajoServicio.findTrabajosByPersona(personaE);
        model.addAttribute("trabajos",trabajos);
        model.addAttribute("persona",persona);
        return "formulario";
    }
    
    @GetMapping("/trabajo/eliminar")
    public String eliminarTrabajo(Trabajo trabajo){
        trabajoServicio.eliminar(trabajo);
        return "redirect:/formulario";
    }
    
    @PostMapping("/guardarTitulo")
    public String guardarTitulo(@RequestParam String username,@RequestParam String titulo,@RequestParam String lugar,@RequestParam String tipo,@RequestParam(required = false) Integer desde,@RequestParam(required = false) Integer hasta,@RequestParam Boolean activo,Model model){
        
        Usuario usuario = servicio.findByEmail(username);
        
        Persona personaE = personaServicio.findById(usuario.getId());
        personaE.setIdPersona(usuario.getPersona().getIdPersona());
        
        FormAcad academico = new FormAcad();
        academico.setTitulo(titulo);
        academico.setLugar(lugar);
        academico.setTipo(tipo);
        academico.setF_inicio(desde);
        academico.setF_fin(hasta);
        academico.setEnProgreso(activo);
        
        academico.setPersona(personaE);
        
        academicoServicio.guardar(academico);
        
        ArrayList<FormAcad> titulos = (ArrayList<FormAcad>) academicoServicio.findTitulosByPersona(personaE);
        model.addAttribute("titulos",titulos);
        model.addAttribute("persona",persona);
        
        return "formulario";
    }
}
