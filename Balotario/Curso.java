package Balotario;

public class Curso {
private String nombre;
private int creditos;

    public Curso(int creditos, String nombre) {
        this.creditos = creditos;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "Curso [nombre=" + nombre + ", creditos=" + creditos + "]";
    }
    
}
