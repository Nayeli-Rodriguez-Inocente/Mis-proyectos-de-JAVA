package ProyectoFinal;
import java.util.Scanner;
import java.util.ArrayList;
public class ClothingList {
static Scanner sc = new Scanner(System.in);
static ArrayList<Clothes>listaRopa=new ArrayList<Clothes>();
    public static void main(String[]args){
        int opcion;
        do{
            System.out.println("================ MENU PRINCIPAL ================");
            System.out.println("1.- Agregar prenda");
            System.out.println("2.- Mostrar prendas");
            System.out.println("3.- Eliminar prenda");
            System.out.println("4.-Modificar prenda");
            System.out.println("5.-Salir");
            System.out.print("Ingrese una opcion:");
            opcion=sc.nextInt();

            switch(opcion){
                case 1: agregarPrenda(listaRopa);
                    break;
                case 2: mostrarPrendas(listaRopa);
                    break;
                case 3: eliminarPrenda(listaRopa);
                    break;
                case 4: modificarPrenda(listaRopa);
                    break;
                case 5: System.out.println("Saliendo...");
                    break;
                default: System.out.println("Opcion no valida");
            }


        }while(opcion!=5);

    }
    static void agregarPrenda(ArrayList<Clothes>listaRopa){
        System.out.print("Ingrese el id de la prenda:");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese la nombre de la prenda:");
        String nombre=sc.nextLine();
        System.out.print("Ingrese la categoria de la prenda:");
        String categoria=sc.nextLine();
        System.out.print("Ingrese la talla de la prenda:");
        String talla=sc.nextLine();
        System.out.print("Ingrese la color de la prenda:");
        String color=sc.nextLine();
        System.out.print("Ingrese la marca de la prenda:");
        String marca=sc.nextLine();
        System.out.print("Ingrese el precio de la prenda:");
        double precio=sc.nextDouble();
        System.out.print("Ingrese el stock de la prenda:");
        int stock=sc.nextInt();

        Clothes prenda=new Clothes( id,nombre,categoria,talla,color,marca,precio,stock);
        listaRopa.add(prenda);
        System.out.println("La prenda se ha agregado correctamente");
    }
    static void mostrarPrendas(ArrayList<Clothes>listaRopa){
        if(listaRopa.isEmpty()){
            System.out.println("No hay prendas en la lista");
            return;
        }
        System.out.println("Lista de prendras:");
        for(Clothes prenda:listaRopa){
            System.out.println("ID:"+prenda.getId());
            System.out.println("Nombre:"+prenda.getNombre());
            System.out.println("Categoria:"+prenda.getCategoria());
            System.out.println("Talla:"+prenda.getTalla());
            System.out.println("Color:"+prenda.getColor());
            System.out.println("Marca:"+prenda.getMarca());
            System.out.println("Precio:"+prenda.getPrecio());
            System.out.println("Stock:"+prenda.getStock());
            System.out.println("--------------------");
        }

    }
    static void eliminarPrenda(ArrayList<Clothes>listaRopa){
        if(listaRopa.isEmpty()){
            System.out.println("No hay prendas en la lista");
            return;
        }
        System.out.print("Ingrese el ID de la prenda a eliminar: ");
    int id = sc.nextInt();
    boolean encontrado = false;

    for (int i = 0; i < listaRopa.size(); i++) {
        if (listaRopa.get(i).getId() == id) {
            listaRopa.remove(i);
            System.out.println("Prenda eliminada correctamente.");
            encontrado = true;
            break;
        }
    }
    if (!encontrado) System.out.println("No se encontró una prenda con ese ID.");
    }
    static void modificarPrenda(ArrayList<Clothes>listaRopa){
        if(listaRopa.isEmpty()){
            System.out.println("No hay prendas en la lista");
            return;
        } 
        mostrarPrendas(listaRopa);
        System.out.print("Ingrese el ID de la prenda a modificar: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < listaRopa.size(); i++) {
            if (listaRopa.get(i).getId() == id) {
                System.out.print("Ingrese el nuevo nombre de la prenda: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese la nueva categoria de la prenda: ");
                String categoria = sc.nextLine();
                System.out.print("Ingrese la nueva talla de la prenda: ");
                String talla = sc.nextLine();
                System.out.print("Ingrese el nuevo color de la prenda: ");
                String color = sc.nextLine();
                System.out.print("Ingrese la nueva marca de la prenda: ");
                String marca = sc.nextLine();
                System.out.print("Ingrese el nuevo precio de la prenda: ");
                double precio = sc.nextDouble();
                System.out.print("Ingrese el nuevo stock de la prenda: ");
                int stock = sc.nextInt();

                Clothes prenda = new Clothes(id, nombre, categoria, talla, color, marca, precio, stock);
                listaRopa.set(i, prenda);
                System.out.println("Prenda modificada correctamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) System.out.println("No se encontró una prenda con ese ID.");
    }

}
