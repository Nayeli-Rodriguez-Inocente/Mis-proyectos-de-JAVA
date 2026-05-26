class Nodo {
    String cancion;
    Nodo sig, ant; // Siguiente y Anterior

    Nodo(String cancion) {
        this.cancion = cancion;
    }
}

class ListaCircularDoble {
    private Nodo cabeza;
    private int cantidad;

    ListaCircularDoble() {
        this.cabeza = null;
        this.cantidad = 0;
    }

    // --- AGREGAR ELEMENTO AL FINAL ---
    public void agregar(String cancion) {
        Nodo nuevoNodo = new Nodo(cancion);

        if (cabeza == null) {
            // Primera inserción
            cabeza = nuevoNodo;
            cabeza.sig = cabeza;
            cabeza.ant = cabeza;
        } else {
            // Insertar al final
            Nodo ultimo = cabeza.ant;
            ultimo.sig = nuevoNodo;
            nuevoNodo.ant = ultimo;
            nuevoNodo.sig = cabeza;
            cabeza.ant = nuevoNodo;
        }
        cantidad++;
        System.out.println("✓ Agregado: " + cancion);
    }

    // --- ELIMINAR ELEMENTO ---
    public boolean eliminar(String cancion) {
        if (cabeza == null) {
            System.out.println("✗ Lista vacía");
            return false;
        }

        Nodo actual = cabeza;

        // Buscar el nodo a eliminar
        for (int i = 0; i < cantidad; i++) {
            if (actual.cancion.equals(cancion)) {
                if (cantidad == 1) {
                    // Último elemento
                    cabeza = null;
                } else {
                    // Conectar anterior con siguiente
                    actual.ant.sig = actual.sig;
                    actual.sig.ant = actual.ant;

                    // Si eliminamos la cabeza, actualizar
                    if (actual == cabeza) {
                        cabeza = actual.sig;
                    }
                }
                cantidad--;
                System.out.println("✓ Eliminado: " + cancion);
                return true;
            }
            actual = actual.sig;
        }

        System.out.println("✗ No encontrado: " + cancion);
        return false;
    }

    // --- RECORRER HACIA ADELANTE ---
    public void recorrer() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }

        Nodo actual = cabeza;
        System.out.println("\n→ Recorrido adelante:");
        for (int i = 0; i < cantidad; i++) {
            System.out.print(actual.cancion);
            if (i < cantidad - 1) System.out.print(" → ");
            actual = actual.sig;
        }
        System.out.println(" → (vuelve al inicio)");
    }

    // --- RECORRER HACIA ATRÁS ---
    public void recorrerAtras() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }

        Nodo actual = cabeza.ant; // Empezar desde el último
        System.out.println("\n← Recorrido atrás:");
        for (int i = 0; i < cantidad; i++) {
            System.out.print(actual.cancion);
            if (i < cantidad - 1) System.out.print(" ← ");
            actual = actual.ant;
        }
        System.out.println(" ← (vuelve al final)");
    }

    // --- OBTENER CANTIDAD DE ELEMENTOS ---
    public int getCantidad() {
        return cantidad;
    }

    // --- BUSCAR ELEMENTO ---
    public boolean existe(String cancion) {
        if (cabeza == null) return false;

        Nodo actual = cabeza;
        for (int i = 0; i < cantidad; i++) {
            if (actual.cancion.equals(cancion)) {
                return true;
            }
            actual = actual.sig;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        ListaCircularDoble playlist = new ListaCircularDoble();

        System.out.println("=== PLAYLIST CIRCULAR ===\n");

        // Agregar canciones
        playlist.agregar("Bohemian Rhapsody");
        playlist.agregar("Hotel California");
        playlist.agregar("Stairway to Heaven");
        playlist.agregar("Imagine");

        // Recorrer la lista
        playlist.recorrer();
        playlist.recorrerAtras();

        // Buscar
        System.out.println("\n¿Existe 'Imagine'? " + playlist.existe("Imagine"));
        System.out.println("¿Existe 'Song X'? " + playlist.existe("Song X"));

        // Eliminar
        System.out.println("\n--- Eliminando 'Hotel California' ---");
        playlist.eliminar("Hotel California");

        playlist.recorrer();

        // Cantidad
        System.out.println("\nTotal de canciones: " + playlist.getCantidad());
    }
}