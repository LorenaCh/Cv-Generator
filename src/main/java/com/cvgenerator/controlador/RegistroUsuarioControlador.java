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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private PersonaServicio personaServicio;

        @Autowired
    private BCryptPasswordEncoder passwordEncoder;
//    public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {
//        super();
//        this.usuarioServicio = usuarioServicio;
//    }
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
            Usuario usuario = usuarioServicio.guardar(registroDTO);

            return "redirect:/registro?exito";
        }
        return "redirect:/registro?fail";
    }

    @GetMapping("/cambiarPassword")
    public String formChangePassword() {
        return "cambiarPassword";
    }

    @PostMapping("/changePassword")
    public String changePassoword(@RequestParam String email, @RequestParam String passwordActual, @RequestParam String passwordNueva) {
        Usuario usuario = usuarioServicio.findByEmail(email);
        if (passwordEncoder.matches(passwordActual,usuario.getPassword())) {
            usuario.setPassword(passwordEncoder.encode(passwordNueva));
            usuarioServicio.guardar(usuario);
            return "redirect:/registro/cambiarPassword?exito";
        }
        return "redirect:/registro/cambiarPassword?fallo";
    }
}
