public class Libro {
    private String titulo;
    private String autor;
    private Integer año;
    public Libro(String titulo, String autor, Integer año) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public Integer getAño() {
        return año;
    }
    public void setAño(Integer año) {
        this.año = año;
    }
    @Override
    public String toString() {
        return "Libro [titulo=" + titulo + ", autor=" + autor + ", año=" + año + "]";
    }
    
}
