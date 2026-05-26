package Balotario;


import java.util.LinkedList;
import java.util.Scanner;

public class CatalogoCursos {
    static LinkedList<Curso> lista = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n=== CATÁLOGO DE CURSOS ===");
            System.out.println("1. Agregar curso en posición");
            System.out.println("2. Eliminar curso en posición");
            System.out.println("3. Mostrar catálogo");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> agregarCurso();
                case 2 -> eliminarCurso();
                case 3 -> mostrarCursos();
                case 4 -> System.out.println("Programa finalizado.");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 4);
    }

    static void agregarCurso() {
        sc.nextLine();
        System.out.print("Nombre del curso: ");
        String nombre = sc.nextLine();
        System.out.print("Créditos: ");
        int creditos = sc.nextInt();



        Curso c= new Curso(nombre, creditos);

        System.out.print("Posición donde insertar (0 a " + lista.size() + "): ");
        int pos = sc.nextInt();

        if (pos >= 0 && pos <= lista.size()) {
            lista.add(pos, c);
            System.out.println("Curso agregado correctamente.");
        } else {
            System.out.println("Posición inválida.");
        }
    }

    static void eliminarCurso() {
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }

        System.out.print("Posición a eliminar (0 a " + (lista.size() - 1) + "): ");
        int pos = sc.nextInt();

        if (pos >= 0 && pos < lista.size()) {
            Curso eliminado = lista.remove(pos);
            System.out.println("Curso eliminado: " + eliminado.getNombre());
        } else {
            System.out.println("Posición inválida.");
        }
    }

    static void mostrarCursos() {
        if (lista.isEmpty()) {
            System.out.println("No hay cursos en el catálogo.");
        } else {
            System.out.println("\nListado de cursos:");
            for (int i = 0; i < lista.size(); i++) {
                System.out.print("Posición " + i + ": ");
                lista.get(i).mostrar();
            }
        }
    }
}

