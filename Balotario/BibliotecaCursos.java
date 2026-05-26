
import java.util.LinkedList;
import java.util.Scanner;

public class BibliotecaCursos {
    static LinkedList<Libro>listalibros=new LinkedList<>();
    static Scanner sc=new Scanner (System.in);
    public static void main(String[]args){
        int opcion;
        do{
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Mostrar libros");
            System.out.println("4. Salir");
            System.out.print("opcion:");
            opcion = sc.nextInt();

            switch(opcion){
                case 1-> agregarLibro();
                case 2-> eliminarLibro();
                case 3 -> mostrarLibros();
                case 4-> System.out.println("programa finalizado");
                default-> System.out.println("opcion invalida");
            }
        }while(opcion!=4);
    }

    public static void agregarLibro(){
sc.nextLine();
        System.out.print("Ingrese título:");
        String titulo=sc.nextLine();
        System.out.print("Ingrese autor: ");
        String autor = sc.nextLine();
        System.out.print("Ingrese año: ");
        Integer año = sc.nextInt();
        sc.nextLine();
        
        Libro libro = new Libro(titulo, autor, año);
        listalibros.add(libro);
        System.out.println("Libro agregado exitosamente.\n");
    }

    public static void eliminarLibro(){
        if(listalibros.isEmpty()){
            System.out.println("No hay libros para eliminar.\n");
            return;
        }
        mostrarLibros();
        System.out.print("Ingrese el índice del libro a eliminar: ");
        int indice = sc.nextInt();
        sc.nextLine();
        
        if(indice >= 0 && indice < listalibros.size()){
            listalibros.remove(indice);
            System.out.println("Libro eliminado exitosamente.\n");
        } else {
            System.out.println("Índice inválido.\n");
        }
    }

    public static void mostrarLibros(){
        if(listalibros.isEmpty()){
            System.out.println("La biblioteca está vacía.\n");
            return;
        }
        System.out.println("\n=== LIBROS EN LA BIBLIOTECA ===");
        for(int i = 0; i < listalibros.size(); i++){
            System.out.println(i + ". " + listalibros.get(i));
        }
        System.out.println("===============================\n");
    }
}
