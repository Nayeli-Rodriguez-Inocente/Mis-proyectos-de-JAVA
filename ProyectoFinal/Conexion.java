package ProyectoFinal;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    static String url = "jdbc:sqlserver://AZUL\\LENOVO:3306;databaseName=Ropa";
    static String usuario = "AZUL";
    static String contrasena = "3306";

    public static void main(String[] args) {
        getConexion();
    }

    public static Connection getConexion() {
        try {
            Connection cn = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión exitosa");
            return cn;
        } catch (Exception e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }

}

