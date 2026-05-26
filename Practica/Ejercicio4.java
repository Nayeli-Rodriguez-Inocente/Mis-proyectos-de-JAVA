package Practica;

public class Ejercicio4 {
    public static void main(String[]args){

        int[][] matrizA={
            {1,2,3,4},
            {6,7,8,9},
            {11,12,13,14},
            {17,18,19,20},
            {22,23,24,25},
            {27,28,29,30}
        
        };
        int[][] matrizB={
            {32,33,34,35},
            {37,38,39,40},
            {42,43,44,45},
            {47,48,49,50},
            {51,52,53,54},
            {55,56,57,58}
            
        
        };
        int[][] matrizC=new int[6][4];
        for(int i=0;i<matrizA.length;i++){
            for(int j=0;j<matrizB[0].length;j++){
                matrizC[i][j]=matrizA[i][j]+matrizB[i][j];
            }
        }

for( int[]fila:matrizC){
    for (int elemento:fila)
        System.out.print("Elemento:"+elemento+" ");
    System.out.println();
}
    }

}
