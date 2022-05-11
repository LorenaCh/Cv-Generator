package com.cvgenerator.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cvgenerator.controlador.dto.UsuarioRegistroDTO;
import com.cvgenerator.entidades.Persona;
import com.cvgenerator.entidades.Rol;
import com.cvgenerator.entidades.Usuario;
import com.cvgenerator.repositorio.UsuarioRepositorio;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private RolServicio rolServicio;
    
    @Autowired
    private PersonaServicio personaServicio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        super();
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO) {

        Rol rol = rolServicio.buscarPorNombre("ROLE_USER");
        if(rol == null){
            rol = new Rol("ROLE_USER");
            rol = rolServicio.guardar(rol);
        }
        Persona persona = personaServicio.guardar(new Persona());
        Usuario usuario = new Usuario(registroDTO.getEmail(),
                passwordEncoder.encode(registroDTO.getPassword()), 
                Arrays.asList(rol),
                persona);
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public boolean existeEmail(String email) {
        return usuarioRepositorio.existsByEmail(email);
    }

    public Optional<Usuario> buscarPorId(Usuario usuario) {
        return usuarioRepositorio.findById(usuario.getId());
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepositorio.findById(id);
    }

    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepositorio.findByEmail(email);
    }
}
