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

/**
 * Controlador que gestiona las operaciones relacionadas con las formaciones.
 */
@RestController
public class FormacionController {

    /** Servicio de formación que realiza las operaciones de negocio. */
    @Autowired
    private FormacionService service;

    /**
     * Endpoint para listar todas las formaciones existentes.
     *
     * @return Una lista de objetos Formacion.
     */
    @GetMapping(value = "/formacion", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Formacion> listarCursos() {
        return service.listaCursosExistentes();
    }

    /**
     * Endpoint para dar de alta una nueva formación.
     *
     * @param formacion El objeto Formacion a añadir.
     */
    @PostMapping(value = "/formacion", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void altaFormacion(@RequestBody Formacion formacion) {
        service.darAltaCurso(formacion);
    }
}
