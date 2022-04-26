package com.cvgenerator.servicio;

import com.cvgenerator.entidades.Rol;
import com.cvgenerator.repositorio.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServicio {
    
    @Autowired
    private RolRepositorio rolRepositorio;
    
    public Rol buscarPorNombre(String nombre){
        return rolRepositorio.findByNombre(nombre);
    }
}
