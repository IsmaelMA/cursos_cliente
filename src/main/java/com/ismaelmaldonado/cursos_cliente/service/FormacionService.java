package com.ismaelmaldonado.cursos_cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ismaelmaldonado.cursos_cliente.model.Curso;
import com.ismaelmaldonado.cursos_cliente.model.Formacion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormacionService implements IFormacionService {

    @Autowired
    private RestTemplate template;

    private final String url = "http://localhost:8080/";

    @Override
    public List<Formacion> listaCursosExistentes() {
        Curso[] cursosArray = template.getForObject(url + "cursos", Curso[].class);
        return Arrays.stream(cursosArray)
                .map(this::convertirCursoAFormacion)
                .collect(Collectors.toList());
    }

    @Override
    public void darAltaCurso(Formacion formacion) {
        ResponseEntity<Curso> response = template.postForEntity(url + "curso/" + formacion.getCurso(), null,
                Curso.class);
        if (response.getStatusCode() == HttpStatus.NOT_FOUND || response.getBody() == null) {
            Curso nuevoCurso = convertirFormacionACurso(formacion);
            template.postForEntity(url + "curso", nuevoCurso, Void.class);
        }
    }

    private Formacion convertirCursoAFormacion(Curso curso) {
        int asignaturas = (curso.getDuracion() >= 50) ? 10 : 5;
        return new Formacion(curso.getNombre(), asignaturas, curso.getPrecio());
    }

    private Curso convertirFormacionACurso(Formacion formacion) {
        Curso curso = new Curso();
        // Si usas codCurso como identificador:
        curso.setCodCurso(formacion.getCurso());
        curso.setNombre(formacion.getCurso());
        curso.setDuracion(formacion.getAsignaturas() * 10);
        curso.setPrecio(formacion.getPrecio());
        return curso;
    }

}
