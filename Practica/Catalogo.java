package Practica;
import java.util.LinkedList;
public class Catalogo {
    public static void main(String[]args){
    LinkedList<Producto> catalogo=new LinkedList<>();
    catalogo.add(new Producto(1,"Coca-Cola",1.5,10));
    catalogo.add(new Producto(2,"Pepsi",1.4,15));
    catalogo.add(new Producto(3,"Fanta",1.3,20));
    catalogo.add(new Producto(4,"Crush",1.2,25));
    int n=catalogo.size();
    for(int i=0;i<n-1;i++){
        for(int j=0;j<n-1-i;j++){
            if(catalogo.get(j).getPrecio()>catalogo.get(j+1).getPrecio()){
                Producto temp=catalogo.get(j);
                catalogo.set(j,catalogo.get(j+1));
                catalogo.set(j+1,temp);
            }
        }
    }

System.out.println("Catalogo ordenado por precio:");
for(Producto p:catalogo){
System.out.println(p.getId()+". "+p.getNombre()+": $"+p.getPrecio());
}
    }
}
