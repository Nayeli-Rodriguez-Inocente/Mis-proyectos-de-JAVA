import java.util.Scanner;

public class OrderedSinglyLinkedListApp {
    // Clase para representar una canción
    static class Song implements Comparable<Song> {
        String title;
        String artist;
        int duration; // en segundos

        Song(String title, String artist, int duration) {
            this.title = title;
            this.artist = artist;
            this.duration = duration;
        }

        @Override
        public int compareTo(Song other) {
            return this.title.compareToIgnoreCase(other.title);
        }

        @Override
        public String toString() {
            int minutes = duration / 60;
            int seconds = duration % 60;
            return String.format("\"%s\" - %s (%d:%02d)", title, artist, minutes, seconds);
        }
    }

    // Nodo de la lista
    static class Node {
        Song song;
        Node next;
        Node(Song song) { this.song = song; }
    }

    // Lista enlazada simple ordenada por nombre de canción
    static class Playlist {
        private Node head;

        // Inserta canción manteniendo orden alfabético (no permite duplicados)
        public void insert(Song song) {
            Node newNode = new Node(song);
            if (head == null || song.compareTo(head.song) < 0) {
                newNode.next = head;
                head = newNode;
                return;
            }
            Node prev = null;
            Node cur = head;
            while (cur != null && song.compareTo(cur.song) >= 0) {
                if (song.title.equalsIgnoreCase(cur.song.title)) { // evitar duplicados
                    System.out.println("La canción '" + song.title + "' ya existe en la playlist.");
                    return;
                }
                prev = cur;
                cur = cur.next;
            }
            prev.next = newNode;
            newNode.next = cur;
        }

        // Elimina canción por nombre
        public boolean remove(String title) {
            if (head == null) return false;
            if (head.song.title.equalsIgnoreCase(title)) {
                head = head.next;
                return true;
            }
            Node prev = head;
            Node cur = head.next;
            while (cur != null) {
                if (cur.song.title.equalsIgnoreCase(title)) {
                    prev.next = cur.next;
                    return true;
                }
                prev = cur;
                cur = cur.next;
            }
            return false;
        }

        // Búsqueda iterativa por nombre: devuelve posición o -1
        public int searchIterative(String title) {
            Node cur = head;
            int index = 0;
            while (cur != null) {
                if (cur.song.title.equalsIgnoreCase(title)) return index;
                cur = cur.next;
                index++;
            }
            return -1;
        }

        // Búsqueda recursiva por nombre: devuelve posición o -1
        public int searchRecursive(String title) {
            return searchRecursiveHelper(head, title, 0);
        }

        private int searchRecursiveHelper(Node node, String title, int idx) {
            if (node == null) return -1;
            if (node.song.title.equalsIgnoreCase(title)) return idx;
            return searchRecursiveHelper(node.next, title, idx + 1);
        }

        // Imprime la playlist
        public void printPlaylist() {
            if (head == null) {
                System.out.println("[Playlist vacía]");
                return;
            }
            System.out.println("\n=== PLAYLIST ===");
            Node cur = head;
            int count = 1;
            int totalSeconds = 0;
            while (cur != null) {
                System.out.printf("%d. %s%n", count, cur.song);
                totalSeconds += cur.song.duration;
                cur = cur.next;
                count++;
            }
            int minutes = totalSeconds / 60;
            int seconds = totalSeconds % 60;
            System.out.printf("Total: %d canciones, duración: %d:%02d%n", count - 1, minutes, seconds);
            System.out.println("================\n");
        }

        // Obtiene número de canciones
        public int size() {
            int count = 0;
            Node cur = head;
            while (cur != null) {
                count++;
                cur = cur.next;
            }
            return count;
        }

        // Vacía la playlist
        public void clear() {
            head = null;
        }
    }

    // Menú de consola
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Playlist playlist = new Playlist();
        boolean running = true;

        System.out.println("╔════════════════════════════╗");
        System.out.println("║  GESTOR DE PLAYLIST (MP3)  ║");
        System.out.println("╚════════════════════════════╝\n");

        while (running) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1) Agregar canción");
            System.out.println("2) Eliminar canción");
            System.out.println("3) Buscar canción (iterativa)");
            System.out.println("4) Buscar canción (recursiva)");
            System.out.println("5) Ver playlist");
            System.out.println("6) Vaciar playlist");
            System.out.println("0) Salir");
            System.out.print("Elige una opción: ");

            int option;
            try {
                option = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida.");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("Nombre de la canción: ");
                    String title = sc.nextLine().trim();
                    if (title.isEmpty()) {
                        System.out.println("❌ El nombre no puede estar vacío.");
                        break;
                    }
                    System.out.print("Artista: ");
                    String artist = sc.nextLine().trim();
                    if (artist.isEmpty()) {
                        System.out.println("❌ El artista no puede estar vacío.");
                        break;
                    }
                    System.out.print("Duración (segundos): ");
                    try {
                        int duration = Integer.parseInt(sc.nextLine().trim());
                        if (duration <= 0) {
                            System.out.println("❌ La duración debe ser mayor a 0.");
                            break;
                        }
                        Song newSong = new Song(title, artist, duration);
                        playlist.insert(newSong);
                        System.out.println("✓ Canción agregada: " + newSong);
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Duración inválida.");
                    }
                    break;

                case 2:
                    System.out.print("Nombre de la canción a eliminar: ");
                    String titleToRemove = sc.nextLine().trim();
                    boolean removed = playlist.remove(titleToRemove);
                    if (removed) {
                        System.out.println("✓ Canción '" + titleToRemove + "' eliminada.");
                    } else {
                        System.out.println("❌ Canción no encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Nombre de la canción a buscar (iterativa): ");
                    String titleSearch = sc.nextLine().trim();
                    int posIter = playlist.searchIterative(titleSearch);
                    if (posIter >= 0) {
                        System.out.println("✓ Encontrado en posición " + (posIter + 1));
                    } else {
                        System.out.println("❌ No encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Nombre de la canción a buscar (recursiva): ");
                    String titleSearchRec = sc.nextLine().trim();
                    int posRec = playlist.searchRecursive(titleSearchRec);
                    if (posRec >= 0) {
                        System.out.println("✓ Encontrado en posición " + (posRec + 1));
                    } else {
                        System.out.println("❌ No encontrado.");
                    }
                    break;

                case 5:
                    playlist.printPlaylist();
                    break;

                case 6:
                    playlist.clear();
                    System.out.println("✓ Playlist vaciada.");
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("❌ Opción no válida.");
            }
        }
        sc.close();
        System.out.println("\n¡Hasta luego! 🎵");
    }
}
