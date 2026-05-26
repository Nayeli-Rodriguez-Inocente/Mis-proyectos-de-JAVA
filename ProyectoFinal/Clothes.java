package ProyectoFinal;

public class Clothes {
    private int id;
    private String nombre;
    private String categoria;
    private String talla;
    private String color;
    private String marca;
    private double precio;
    private int stock;

    public Clothes(int id, String nombre, String categoria, String talla, String color, String marca, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.talla = talla;
        this.color = color;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Clothes [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", talla=" + talla + ", color=" + color
                + ", marca=" + marca + ", precio=" + precio + ", stock=" + stock + "]";
    }

}
