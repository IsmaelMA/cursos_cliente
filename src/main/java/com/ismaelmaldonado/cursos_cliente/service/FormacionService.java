package com.ismaelmaldonado.cursos_cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ismaelmaldonado.cursos_cliente.model.Curso;
import com.ismaelmaldonado.cursos_cliente.model.Formacion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio que gestiona las operaciones relacionadas con las
 * formaciones.
 */
@Service
public class FormacionService implements IFormacionService {

    /** Cliente HTTP para realizar peticiones a otros servicios. */
    @Autowired
    private RestTemplate template;

    /** URL base del servicio al que se harán las peticiones. */
    private final String url = "http://localhost:8080/";

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Formacion> listaCursosExistentes() {
        Curso[] cursosArray = template.getForObject(url + "cursos", Curso[].class);
        return Arrays.stream(cursosArray)
                .map(this::convertirCursoAFormacion)
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void darAltaCurso(Formacion formacion) {
        Curso nuevoCurso = convertirFormacionACurso(formacion);
        ResponseEntity<List<Curso>> response = template.exchange(url + "cursos", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Curso>>() {
                });
        List<Curso> cursos = response.getBody();
        boolean cursoExiste = false;
        for (Curso curso : cursos) {
            if (curso.getNombre().equals(nuevoCurso.getNombre())) {
                cursoExiste = true;
                break;
            }
        }
        if (!cursoExiste) {
            template.postForEntity(url + "curso", nuevoCurso, Void.class);
        }
    }

    /**
     * Convierte un objeto Curso a Formacion basándose en sus atributos.
     *
     * @param curso El objeto Curso a convertir.
     * @return Un objeto Formacion.
     */
    private Formacion convertirCursoAFormacion(Curso curso) {
        int asignaturas = (curso.getDuracion() >= 50) ? 10 : 5;
        return new Formacion(curso.getNombre(), asignaturas, curso.getPrecio());
    }

    /**
     * Convierte un objeto Formacion a Curso basándose en sus atributos.
     *
     * @param formacion El objeto Formacion a convertir.
     * @return Un objeto Curso.
     */
    private Curso convertirFormacionACurso(Formacion formacion) {
        Curso curso = new Curso();

        curso.setCodCurso(formacion.getCurso());
        curso.setNombre(formacion.getCurso());
        curso.setDuracion(formacion.getAsignaturas() * 10);
        curso.setPrecio(formacion.getPrecio());
        return curso;
    }

}