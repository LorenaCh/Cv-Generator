package com.cvgenerator.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;
    private Integer dni;
    private String nombre;
    private String apellido;
    private String foto;
    private Date fNac;
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "id_usuario  ")
    @Nullable
    private Usuario usuario;

    /*
    @OneToMany
    private List <Trabajo> trabajos;
    @OneToMany
    private List <FormAcad> formaciones;
    @OneToMany
    private List <Aptitudes> aptitud;*/

    public Persona(Integer idPersona, Integer dni, String nombre, String apellido, String foto, Date fNac, String descripcion) {
        this.idPersona = idPersona;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.foto = foto;
        this.fNac = fNac;
        this.descripcion = descripcion;
    }

    public Persona() {
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getfNac() {
        return fNac;
    }

    public void setfNac(Date fNac) {
        this.fNac = fNac;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", foto=" + foto + ", fNac=" + fNac + ", descripcion=" + descripcion + ", usuario=" + usuario + '}';
    }

}
