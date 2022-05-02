package com.cvgenerator.entidades;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
    )
    private Collection<Rol> roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
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

    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario(Long id, String email, String password, Collection<Rol> roles,Persona persona) {
        super();
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.persona = persona;
    }

    public Usuario(String email, String password, Collection<Rol> roles,Persona persona) {
        super();
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.persona = persona;
    }

    public Usuario() {

    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", email=" + email + ", password=" + password + ", roles=" + roles + ", persona=" + persona + '}';
    }


}
