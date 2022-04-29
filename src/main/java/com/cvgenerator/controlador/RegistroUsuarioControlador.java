package com.cvgenerator.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cvgenerator.controlador.dto.UsuarioRegistroDTO;
import com.cvgenerator.entidades.Persona;
import com.cvgenerator.entidades.Usuario;
import com.cvgenerator.servicio.PersonaServicio;
import com.cvgenerator.servicio.UsuarioServicio;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    private UsuarioServicio usuarioServicio;
    private PersonaServicio personaServicio;

    public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {
        super();
        this.usuarioServicio = usuarioServicio;
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
        if (usuarioServicio.existeEmail(registroDTO.getEmail()) == false) {
            Persona persona = personaServicio.guardar(personaServicio.crear());
            System.out.println(persona);
            registroDTO.setPersona(persona);
            Usuario usuario = usuarioServicio.guardar(registroDTO);
            System.out.println(usuario);
            persona.setUsuario(usuario);
            persona = personaServicio.guardar(persona);
            System.out.println(persona);
            //usuario = usuarioServicio.findById(persona.getUsuario().getId());
            //usuario.setPersona(persona);
            //usuarioServicio.guardar(usuario);
            return "redirect:/registro?exito";
        }
        return "redirect:/registro?fail";
    }
}
