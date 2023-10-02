package com.ismaelmaldonado.cursos_cliente.model;

public class Curso {

    private String codCurso; // Código asignado al curso
    private String nombre; // Nombre del curso
    private int duracion; // Duración en número de horas del curso
    private double precio; // Precio del curso

    public Curso() {
    }

    public Curso(String codCurso, String nombre, int duracion, double precio) {
        this.codCurso = codCurso;
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
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
        result = prime * result + ((codCurso == null) ? 0 : codCurso.hashCode());
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
        Curso other = (Curso) obj;
        if (codCurso == null) {
            if (other.codCurso != null)
                return false;
        } else if (!codCurso.equals(other.codCurso))
            return false;
        return true;
    }

    public Curso convertirFormacionACurso(Formacion formacion) {
        Curso curso = new Curso();
        curso.setCodCurso(formacion.getCurso());
        curso.setNombre(formacion.getCurso());
        curso.setDuracion(formacion.getAsignaturas() * 10);
        curso.setPrecio(formacion.getPrecio());
        return curso;
    }

    @Override
    public String toString() {
        return "Curso [codCurso=" + codCurso + ", nombre=" + nombre + ", duracion=" + duracion + ", precio=" + precio
                + "]";
    }
}
