package com.ismaelmaldonado.cursos_cliente.model;

/**
 * Representa un curso con atributos de código, nombre, duración y precio.
 */
public class Curso {

    /** Código asignado al curso. */
    private String codCurso;

    /** Nombre del curso. */
    private String nombre;

    /** Duración en número de horas del curso. */
    private int duracion;

    /** Precio del curso. */
    private double precio;

    /**
     * Constructor por defecto.
     */
    public Curso() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param codCurso Código del curso.
     * @param nombre   Nombre del curso.
     * @param duracion Duración en horas del curso.
     * @param precio   Precio del curso.
     */
    public Curso(String codCurso, String nombre, int duracion, double precio) {
        this.codCurso = codCurso;
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
    }

    /**
     * Obtiene el código del curso.
     *
     * @return El código del curso.
     */
    public String getCodCurso() {
        return codCurso;
    }

    /**
     * Establece el código del curso.
     *
     * @param codCurso El nuevo código del curso.
     */
    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    /**
     * Obtiene el nombre del curso.
     *
     * @return El nombre del curso.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del curso.
     *
     * @param nombre El nuevo nombre del curso.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la duración del curso.
     *
     * @return La duración del curso.
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Establece la duración del curso.
     *
     * @param duracion La nueva duración del curso.
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Obtiene el precio del curso.
     *
     * @return El precio del curso.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del curso.
     *
     * @param precio El nuevo precio del curso.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Convierte un objeto Formacion a Curso basándose en sus atributos.
     *
     * @param formacion El objeto Formacion a convertir.
     * @return Un objeto Curso.
     */
    public Curso convertirFormacionACurso(Formacion formacion) {
        Curso curso = new Curso();
        curso.setCodCurso(formacion.getCurso());
        curso.setNombre(formacion.getCurso());
        curso.setDuracion(formacion.getAsignaturas() * 10);
        curso.setPrecio(formacion.getPrecio());
        return curso;
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

    @Override
    public String toString() {
        return "Curso [codCurso=" + codCurso + ", nombre=" + nombre + ", duracion=" + duracion + ", precio=" + precio
                + "]";
    }
}
