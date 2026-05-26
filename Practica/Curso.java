package Practica;

public class Curso {
    private int duracion;
    private String nombre;
    

    public Curso(int duracion, String nombre) {
        this.duracion = duracion;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Curso [nombre=" + nombre + ", duracion=" + duracion + "]";
    }

}
