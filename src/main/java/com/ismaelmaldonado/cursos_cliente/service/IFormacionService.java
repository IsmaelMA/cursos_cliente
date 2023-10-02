package com.ismaelmaldonado.cursos_cliente.service;

import java.util.List;

import com.ismaelmaldonado.cursos_cliente.model.Formacion;

public interface IFormacionService {

    public List<Formacion> listaCursosExistentes();

    public void darAltaCurso(Formacion formacion);
}
