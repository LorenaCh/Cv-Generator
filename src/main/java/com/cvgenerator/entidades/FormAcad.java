/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvgenerator.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author barby
 */
@Entity
public class FormAcad implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_formAcad")
    private Integer idFormAcad;
    
    private String titulo;
    private String establecimiento;
    private String tipo;
    private Integer f_inicio;
    private Integer f_fin ;
    private Boolean enProgreso;
    private String lugar;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    public FormAcad() {
    }

    public FormAcad(Integer idFormAcad, String titulo, String establecimiento, String tipo, Integer f_inicio, Integer f_fin, Boolean enProgreso, String lugar) {
        this.idFormAcad = idFormAcad;
        this.titulo = titulo;
        this.establecimiento = establecimiento;
        this.tipo = tipo;
        this.f_inicio = f_inicio;
        this.f_fin = f_fin;
        this.enProgreso = enProgreso;
        this.lugar = lugar;
    }

    public Integer getIdFormAcad() {
        return idFormAcad;
    }

    public void setIdFormAcad(Integer idFormAcad) {
        this.idFormAcad = idFormAcad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getF_inicio() {
        return f_inicio;
    }

    public void setF_inicio(Integer f_inicio) {
        this.f_inicio = f_inicio;
    }

    public Integer getF_fin() {
        return f_fin;
    }

    public void setF_fin(Integer f_fin) {
        this.f_fin = f_fin;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Boolean getEnProgreso() {
        return enProgreso;
    }

    public void setEnProgreso(Boolean enProgreso) {
        this.enProgreso = enProgreso;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "FormAcad{" + "idFormAcad=" + idFormAcad + ", titulo=" + titulo + ", establecimiento=" + establecimiento + ", tipo=" + tipo + ", f_inicio=" + f_inicio + ", f_fin=" + f_fin + ", enProgreso=" + enProgreso + ", lugar=" + lugar + '}';
    }
    
    
}
