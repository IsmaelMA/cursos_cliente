package com.ismaelmaldonado.cursos_cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ismaelmaldonado.cursos_cliente.model.Formacion;
import com.ismaelmaldonado.cursos_cliente.service.FormacionService;

import java.util.List;

@RestController
public class FormacionController {

    @Autowired
    private FormacionService service;

    @GetMapping(value = "/formacion", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Formacion> listarCursos() {
        return service.listaCursosExistentes();
    }

    @PostMapping(value = "/formacion", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void altaFormacion(@RequestBody Formacion formacion) {
        service.darAltaCurso(formacion);
    }
}