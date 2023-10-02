package com.ismaelmaldonado.cursos_cliente.model;

public class Formacion {

    private String curso;
    private int asignaturas;
    private double precio;

    public Formacion() {
    }

    public Formacion(String curso, int asignaturas, double precio) {
        this.curso = curso;
        this.asignaturas = asignaturas;
        this.precio = precio;
    }

    public Formacion convertirCursoAFormacion(Curso curso) {
        int asignaturas = (curso.getDuracion() >= 50) ? 10 : 5;
        return new Formacion(curso.getNombre(), asignaturas, curso.getPrecio());
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(int asignaturas) {
        this.asignaturas = asignaturas;
    }

    public double getPrecio() {
        return precio;
    }

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
