package Practica;

public class Alumnos {
    public static void main(String[] args) {

        Alumno Alumnos[]=new Alumno[5];
        Alumnos[0]=new Alumno("Juan",20.5);
        Alumnos[1]=new Alumno("Carlos",14.0);
        Alumnos[2]=new Alumno("Karina",16.9);
        Alumnos[3]=new Alumno("Carla",18.0);
        Alumnos[4]=new Alumno("Cassie",19.8);
        
        int indiceMayor=0;
        for(int i=1;i<Alumnos.length;i++){
            if(Alumnos[i].getNota()>Alumnos[indiceMayor].getNota()){
                indiceMayor=i;

            }

        }
    System.out.println("El alumno con la nota más alta es "+Alumnos[indiceMayor].getNombre() + " con una nota de "+Alumnos[indiceMayor].getNota());
    }

}
