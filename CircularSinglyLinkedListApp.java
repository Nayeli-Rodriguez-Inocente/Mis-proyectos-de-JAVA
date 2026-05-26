import java.util.Scanner;

public class CircularSinglyLinkedListApp {
    static class Node {
        int value;
        Node next;
        Node(int v) { value = v; }
    }

    static class CircularSinglyLinkedList {
        private Node tail; // tail.next is head, null if empty
        private int size = 0;

        public boolean isEmpty() { return tail == null; }
        public int size() { return size; }

        // Insert at end (maintains circular property)
        public void insert(int val) {
            Node node = new Node(val);
            if (tail == null) {
                tail = node;
                tail.next = tail;
            } else {
                node.next = tail.next;
                tail.next = node;
                tail = node;
            }
            size++;
        }

        // Insert at head (useful)
        public void insertAtHead(int val) {
            Node node = new Node(val);
            if (tail == null) {
                tail = node;
                tail.next = tail;
            } else {
                node.next = tail.next;
                tail.next = node;
            }
            size++;
        }

        // Remove first occurrence of value, returns true if removed
        public boolean remove(int val) {
            if (tail == null) return false;
            Node cur = tail.next; // head
            Node prev = tail;
            int traversed = 0;
            while (traversed < size) {
                if (cur.value == val) {
                    if (cur == tail && cur == tail.next) { // only one node
                        tail = null;
                    } else {
                        prev.next = cur.next;
                        if (cur == tail) tail = prev; // removed tail -> update
                    }
                    size--;
                    return true;
                }
                prev = cur;
                cur = cur.next;
                traversed++;
            }
            return false;
        }

        // Search returns index (0-based from head) or -1
        public int search(int val) {
            if (tail == null) return -1;
            Node cur = tail.next; // head
            int idx = 0;
            int traversed = 0;
            while (traversed < size) {
                if (cur.value == val) return idx;
                cur = cur.next;
                idx++;
                traversed++;
            }
            return -1;
        }

        // Get value at index (0-based from head), throws if out of range
        public int get(int index) {
            if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
            Node cur = tail.next;
            for (int i = 0; i < index; i++) cur = cur.next;
            return cur.value;
        }

        // Rotate list by n steps (positive -> move head forward)
        public void rotate(int n) {
            if (tail == null || size <= 1) return;
            n = ((n % size) + size) % size;
            for (int i = 0; i < n; i++) tail = tail.next;
        }

        // Clear list
        public void clear() {
            tail = null;
            size = 0;
        }

        // Print elements starting from head
        public void printList() {
            if (tail == null) {
                System.out.println("[vacía]");
                return;
            }
            StringBuilder sb = new StringBuilder();
            Node cur = tail.next;
            int traversed = 0;
            while (traversed < size) {
                sb.append(cur.value);
                if (traversed < size - 1) sb.append(" -> ");
                cur = cur.next;
                traversed++;
            }
            sb.append(" -> (head)");
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        boolean running = true;

        while (running) {
            System.out.println("\nLista enlazada circular simple - Opciones:");
            System.out.println("1) Insertar al final");
            System.out.println("2) Insertar al inicio");
            System.out.println("3) Eliminar valor");
            System.out.println("4) Buscar valor");
            System.out.println("5) Obtener por índice");
            System.out.println("6) Rotar lista");
            System.out.println("7) Imprimir lista");
            System.out.println("8) Vaciar lista");
            System.out.println("0) Salir");
            System.out.print("Elige una opción: ");

            String line = sc.nextLine().trim();
            int option;
            try { option = Integer.parseInt(line); }
            catch (Exception e) { System.out.println("Entrada inválida."); continue; }

            switch (option) {
                case 1:
                    System.out.print("Número a insertar al final: ");
                    try {
                        int v = Integer.parseInt(sc.nextLine().trim());
                        list.insert(v);
                        System.out.println("Insertado.");
                    } catch (Exception e) { System.out.println("Número inválido."); }
                    break;
                case 2:
                    System.out.print("Número a insertar al inicio: ");
                    try {
                        int v = Integer.parseInt(sc.nextLine().trim());
                        list.insertAtHead(v);
                        System.out.println("Insertado al inicio.");
                    } catch (Exception e) { System.out.println("Número inválido."); }
                    break;
                case 3:
                    System.out.print("Número a eliminar: ");
                    try {
                        int v = Integer.parseInt(sc.nextLine().trim());
                        boolean removed = list.remove(v);
                        System.out.println(removed ? "Eliminado." : "No encontrado.");
                    } catch (Exception e) { System.out.println("Número inválido."); }
                    break;
                case 4:
                    System.out.print("Número a buscar: ");
                    try {
                        int v = Integer.parseInt(sc.nextLine().trim());
                        int pos = list.search(v);
                        System.out.println(pos >= 0 ? "Encontrado en posición " + pos : "No encontrado.");
                    } catch (Exception e) { System.out.println("Número inválido."); }
                    break;
                case 5:
                    System.out.print("Índice (0-based): ");
                    try {
                        int idx = Integer.parseInt(sc.nextLine().trim());
                        int value = list.get(idx);
                        System.out.println("Valor en índice " + idx + " = " + value);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Índice fuera de rango.");
                    } catch (Exception e) {
                        System.out.println("Entrada inválida.");
                    }
                    break;
                case 6:
                    System.out.print("Rotar n pasos (positivo derecha/head avanza): ");
                    try {
                        int n = Integer.parseInt(sc.nextLine().trim());
                        list.rotate(n);
                        System.out.println("Rotado " + n + " pasos.");
                    } catch (Exception e) { System.out.println("Entrada inválida."); }
                    break;
                case 7:
                    System.out.println("Contenido de la lista:");
                    list.printList();
                    break;
                case 8:
                    list.clear();
                    System.out.println("Lista vaciada.");
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        sc.close();
        System.out.println("Programa finalizado.");
    }
}
