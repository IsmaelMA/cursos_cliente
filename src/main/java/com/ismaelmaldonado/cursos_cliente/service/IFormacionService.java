package com.ismaelmaldonado.cursos_cliente.service;

import java.util.List;

import com.ismaelmaldonado.cursos_cliente.model.Formacion;

/**
 * Interfaz que define los métodos de servicio relacionados con las formaciones.
 */
public interface IFormacionService {

    /**
     * Obtiene una lista de todas las formaciones existentes.
     *
     * @return Una lista de objetos Formacion.
     */
    public List<Formacion> listaCursosExistentes();

    /**
     * Da de alta una nueva formación.
     *
     * @param formacion El objeto Formacion a añadir.
     */
    public void darAltaCurso(Formacion formacion);
}
