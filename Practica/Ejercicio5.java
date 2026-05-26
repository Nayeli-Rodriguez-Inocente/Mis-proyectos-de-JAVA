package Practica;

public class Ejercicio5 {
    public static void main(String[]args){
        int[] A={1,2,3,4,5};
        int[] B={1,2,3,4,5};
        int[] C=new int[5];
        for(int i=0;i<A.length;i++){
            C[i]=A[i]+B[i];
        }
System.out.println("La suma de los elementos de la matriz A y B es:");
for(int i=0;i<C.length;i++){
    System.out.print(C[i]+" ");
}
    }
}
