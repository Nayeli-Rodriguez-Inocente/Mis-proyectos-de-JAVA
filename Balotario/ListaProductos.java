import java.util.LinkedList;
import java.util.Scanner;
public class ListaProductos {
    static LinkedList<Producto>Listaproductos= new LinkedList<>();
    static Scanner Lectura=new Scanner(System.in);
    public static void main(String[]args){
        int opcion;
        do{
            System.out.println("------------------------MENU DE PRODUCTOS-------------------------");
            System.out.println("1.Agregar producto");
            System.out.println("2.Eliminar producto");
            System.out.println("3.Mostrar productos");
            System.out.println("4.Salir");
            System.out.println("Ingrese una opción:");
            opcion =Lectura.nextInt();
            switch(opcion){
                case 1->AgregarProducto();
                case 2->EliminarProducto();
                case 3->MostrarProductos();
                case 4->System.out.println("El programa ha finalizado, gracias por usarlo");
                default->System.out.println("Ingrese una opción válida");
            }




        }while( opcion !=4);
    
    }
static void AgregarProducto(){
    Lectura.nextLine();
    System.out.print("Ingrese el nombre del producto:");
    String nombre=Lectura.nextLine();
    System.out.print("Ingrese el precio del producto:");
    double precio=Lectura.nextDouble();
    System.out.print("Ingrese el stock del producto:");
    int stock=Lectura.nextInt();
    Lectura.nextLine();
    
    Producto producto=new Producto(nombre,precio,stock);
    Listaproductos.add(producto);
    System.out.println("Producto agregado exitosamente");

}
static void EliminarProducto(){
    Lectura.nextLine();
    if(Listaproductos.isEmpty()){
        System.out.println("No se encontraron productos para eliminar");
        return;
    }
    MostrarProductos();
    System.out.print("Ingrese el índice del proudcto a eliminar:");
    int indice=Lectura.nextInt();
    Lectura.nextLine();
    if(indice>=0 && indice<Listaproductos.size()){
        Listaproductos.remove(indice);
        System.out.println("El producto ha sido eliminado exitosamente");

    }else{
        System.out.println("índice inválido");
    }
}

static void MostrarProductos(){
    if(Listaproductos.isEmpty()){
        System.out.println("No se ha encontrado ningún producto para mostrar");
        return;

    }System.out.println("####### LISTA DE PRODUCTOS ######");
    for(int i=0;i<Listaproductos.size();i++){
        System.out.println("indice:"+(i)+"->"+Listaproductos.get(i));
    }


}
}

