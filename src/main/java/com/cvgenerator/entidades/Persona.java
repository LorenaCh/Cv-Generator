package com.cvgenerator.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;
    private String nombre;
    private String apellido;
    private String profesion;
    private Integer telefono;
    private String foto;
    private String correo;
    private Integer edad;
    private String nacionalidad;
    private String direccion;
    private String descripcion;

    @OneToOne(mappedBy = "persona")
    private Usuario usuario;
    
    @Nullable
    @OneToMany(mappedBy = "persona")
    private List <Trabajo> trabajos;
    
    @Nullable
    @OneToMany(fetch=FetchType.LAZY,mappedBy = "persona")
    private List <FormAcad> formaciones;
    @Nullable
    @OneToMany(fetch=FetchType.LAZY,mappedBy = "persona")
    private List <Aptitud> aptitud;
    @Nullable
    @OneToMany(fetch=FetchType.LAZY,mappedBy = "persona")
    private List<Conocimiento> conocimientos;
    @Nullable
    @OneToMany(fetch=FetchType.LAZY,mappedBy = "persona")
    private List<Idioma> idiomas;

    
    public Persona() {
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
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

    public Integer getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
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

    public List<Conocimiento> getConocimientos() {
        return conocimientos;
    }

    public void setConocimientos(List<Conocimiento> conocimientos) {
        this.conocimientos = conocimientos;
    }

    public List<Trabajo> getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(List<Trabajo> trabajos) {
        this.trabajos = trabajos;
    }

    public List<FormAcad> getFormaciones() {
        return formaciones;
    }

    public void setFormaciones(List<FormAcad> formaciones) {
        this.formaciones = formaciones;
    }

    public List<Aptitud> getAptitud() {
        return aptitud;
    }

    public void setAptitud(List<Aptitud> aptitud) {
        this.aptitud = aptitud;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", profesion=" + profesion + ", telefono=" + telefono + ", foto=" + foto + ", correo=" + correo + ", edad=" + edad + ", nacionalidad=" + nacionalidad + ", direccion=" + direccion + ", descripcion=" + descripcion + ", usuario=" + usuario + ", trabajos=" + trabajos + ", formaciones=" + formaciones + ", aptitud=" + aptitud + ", conocimientos=" + conocimientos + ", idiomas=" + idiomas + '}';
    }

}
