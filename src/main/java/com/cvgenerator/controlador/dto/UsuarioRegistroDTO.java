package com.cvgenerator.controlador.dto;

import com.cvgenerator.entidades.Persona;

public class UsuarioRegistroDTO {

    private Long id;
    private String email;
    private String password;
    private Persona persona;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public UsuarioRegistroDTO(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    public UsuarioRegistroDTO() {

    }

    @Override
    public String toString() {
        return "UsuarioRegistroDTO{" + "id=" + id + ", email=" + email + ", password=" + password + ", persona=" + persona + '}';
    }

}
