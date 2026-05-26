package Practica;
import java.util.LinkedList;
import java.util.Scanner;
public class CatalogoCurso {
static Scanner Lector=new Scanner(System.in);
    public static void main(String[]args){
        int opcion;
        LinkedList<Curso>catalogoCursos=new LinkedList<>();
        do{
            System.out.println("=======CATALOGO DE CURSOS=======");
            System.out.println("1.- Agregar curso");
            System.out.println("2.- Eliminar curso");
            System.out.println("3.-  Mostrar catalogo");
            System.out.println("4.-  Salir");
            System.out.println("Ingrese una opción:");
            opcion=Lector.nextInt();
            switch(opcion){
                case 1: AgregarCurso(catalogoCursos);
                    break;
                case 2: EliminarCurso(catalogoCursos);
                    break;
                case 3: MostrarCatalogo(catalogoCursos);
                    break;
                case 4: System.out.println("Progrma finalizado.");
                    break;
                default: System.out.println("Ingrese una opción valida");

            }
            

        }while(opcion!=4);

        }
        static void AgregarCurso(LinkedList<Curso>catalogoCursos){
            Lector.nextLine();

            System.out.println("Ingrese el nombre del curso:");
            String nombre=Lector.nextLine();
            System.out.println("Ingrese el tiempo de duracion de curso:");
            int duracion=Lector.nextInt();
            Lector.nextLine();
            Curso curso=new Curso(duracion,nombre);
            catalogoCursos.add(new Curso(duracion,nombre));
            System.out.println("Curso agregado correctamente.");
        }
        static void EliminarCurso(LinkedList<Curso>catalogoCursos){
            if(catalogoCursos.isEmpty()){
                System.out.println("El catalogo esta vacio.");
                return;
            }MostrarCatalogo(catalogoCursos);
            System.out.print("Ingrese el indice del curso a eliminar:");
            int indice=Lector.nextInt();
            indice=indice-1;
            if(indice>=0 && indice<catalogoCursos.size()){
                catalogoCursos.remove(indice);
                System.out.println("El curso se elimino correctamente.");
            }
            }
            static void MostrarCatalogo(LinkedList<Curso>catalogoCursos){
                if(catalogoCursos.isEmpty()){
                    System.out.println("El catalogo está vacío.");
                    return;
                }for(int indice=0;indice<catalogoCursos.size();indice++){
                    Curso c=catalogoCursos.get(indice);
                    System.out.println((indice+1)+". "+c.getNombre()+" -> Duracion:"+c.getDuracion());
                }

            }


    }
    


