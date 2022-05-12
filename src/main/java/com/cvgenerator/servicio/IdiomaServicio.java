package com.cvgenerator.servicio;

import com.cvgenerator.entidades.Idioma;
import com.cvgenerator.repositorio.IdiomaRepositorio;
import javax.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IdiomaServicio {

    @Autowired
    private IdiomaRepositorio idiReposotorio;
    
    @Transactional
    public Idioma guardar(Idioma idioma){
        return idiReposotorio.save(idioma);
    }
}
