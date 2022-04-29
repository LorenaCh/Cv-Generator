/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvgenerator.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author barby
 */
@Entity
public class FormAcad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_formAcad")
    private Integer idFormAcad;
    
    private String titulo;
    private String establecimiento;
    private String tipo;
    private Date f_inicio ;
    private Date f_fin ;
    private Boolean enProgreso;
    private String lugar;
}
