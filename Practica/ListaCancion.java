package Practica;
import java.util.ArrayList;
import java.util.Scanner;
public class ListaCancion {
    static Scanner sc=new Scanner(System.in);
    static ArrayList<Cancion>ListaCanciones=new ArrayList<>();
    public static void main(String[]args){
    int opcion;
        do{
            System.out.println("==============PLAYLIST==============");
            System.out.println("1.-Agregar cancion");
            System.out.println("2.- Quitar cancion");
            System.out.println("3.-Mostrar por campo(nombre,artista,genero)");
            System.out.println("4.-Salir");
            System.out.println("Ingrese una opcion:");
            opcion=sc.nextInt();
            switch(opcion){
                case 1: AgregarCancion(ListaCanciones);
                break;
                case 2: QuitarCancion(ListaCanciones);
                break;
                case 3: MostrarCanciones(ListaCanciones);
                break;
                case 4: System.out.println("Programa finalizado");
                break;
                default: System.out.println("Ingrese una opcion valida");

            }

        }while(opcion!=4);

        }
    static void AgregarCancion(ArrayList<Cancion>ListaCanciones){
        sc.nextLine();
            System.out.println("Ingrese el nombre de la cancion:");
            String nombre=sc.nextLine();
            System.out.println("Ingrese el nombre del artista::");
            String artista=sc.nextLine();
            System.out.println("Ingrese el nombre del genero::");
            String genero=sc.nextLine();

            Cancion cancion=new Cancion(artista,genero,nombre);
            ListaCanciones.add(cancion);
            System.out.println("Canción agregada exitosamente");
    }
    static void QuitarCancion(ArrayList<Cancion>ListaCanciones){
    if(ListaCanciones.isEmpty()){
        System.out.println("No hay canciones en la lista");
        return;
    }
    MostrarCanciones(ListaCanciones);
    System.out.println("Ingrese el numero de la cancion que desea quitar:");
    int indice=sc.nextInt();
    if(indice>=0 && indice<ListaCanciones.size()){
        ListaCanciones.remove(indice);
        System.out.println("Cancion quitada exitosamente");
    }else{
        System.out.println("Indice invalido");
    }
    }
    static void MostrarCanciones(ArrayList<Cancion>ListaCanciones){
        sc.nextLine();
        if(ListaCanciones.isEmpty()){
            System.out.println("La lista de canciones esta vacia");
            return;
        }
        System.out.println("Busrcar por:");
        System.out.println("A)Nombre");
        System.out.println("B)Artista");
        System.out.println("C)Genero");
        System.out.println("Ingrese una campo:");
        String campo=sc.nextLine();

        switch(campo.toUpperCase()){
            case "A":
                System.out.println("Ingrese el nombre de la cancion:");
                String nombre=sc.nextLine();
                for(Cancion cancion:ListaCanciones){
                if(cancion.getNombre().equalsIgnoreCase(nombre)){
                        System.out.println(cancion);
                    }
                }
                break;
                case "B":
                System.out.println("Ingrese el nombre del artista:");
                String artista=sc.nextLine();
                for(Cancion cancion:ListaCanciones){
                if(cancion.getArtista().equalsIgnoreCase(artista)){
                        System.out.println(cancion);
                    }
                }
                break;
                case "C":
                    System.out.println("Ingrese el nombre del genero:");
                String genero=sc.nextLine();
                for(Cancion cancion:ListaCanciones){
                if(cancion.getGenero().equalsIgnoreCase(genero)){
                        System.out.println(cancion);
                    }
                }
                break;
                    default:
                        System.out.println("Campo invalido");

                }
        }
    }


