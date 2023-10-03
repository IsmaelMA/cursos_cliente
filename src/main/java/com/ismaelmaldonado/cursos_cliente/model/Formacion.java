package com.ismaelmaldonado.cursos_cliente.model;

/**
 * Representa una formación con atributos de curso, asignaturas y precio.
 */
public class Formacion {

    /** Nombre del curso. */
    private String curso;

    /** Número de asignaturas en la formación. */
    private int asignaturas;

    /** Precio de la formación. */
    private double precio;

    /**
     * Constructor por defecto.
     */
    public Formacion() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param curso       Nombre del curso.
     * @param asignaturas Número de asignaturas.
     * @param precio      Precio de la formación.
     */
    public Formacion(String curso, int asignaturas, double precio) {
        this.curso = curso;
        this.asignaturas = asignaturas;
        this.precio = precio;
    }

    /**
     * Convierte un objeto Curso a Formacion basándose en sus atributos.
     *
     * @param curso El objeto Curso a convertir.
     * @return Un objeto Formacion.
     */
    public Formacion convertirCursoAFormacion(Curso curso) {
        int asignaturas = (curso.getDuracion() >= 50) ? 10 : 5;
        return new Formacion(curso.getNombre(), asignaturas, curso.getPrecio());
    }

    /**
     * Devuelve el nombre del curso.
     *
     * @return Nombre del curso.
     */
    public String getCurso() {
        return curso;
    }

    /**
     * Establece el nombre del curso.
     *
     * @param curso Nombre del curso.
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * Devuelve el número de asignaturas.
     *
     * @return Número de asignaturas.
     */
    public int getAsignaturas() {
        return asignaturas;
    }

    /**
     * Establece el número de asignaturas.
     *
     * @param asignaturas Número de asignaturas.
     */
    public void setAsignaturas(int asignaturas) {
        this.asignaturas = asignaturas;
    }

    /**
     * Devuelve el precio de la formación.
     *
     * @return Precio de la formación.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio de la formación.
     *
     * @param precio Precio de la formación.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((curso == null) ? 0 : curso.hashCode());
        result = prime * result + asignaturas;
        long temp;
        temp = Double.doubleToLongBits(precio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Formacion other = (Formacion) obj;
        if (curso == null) {
            if (other.curso != null)
                return false;
        } else if (!curso.equals(other.curso))
            return false;
        if (asignaturas != other.asignaturas)
            return false;
        if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Ejemplar [curso=" + curso + ", asignaturas=" + asignaturas + ", precio=" + precio + "]";
    }

}
