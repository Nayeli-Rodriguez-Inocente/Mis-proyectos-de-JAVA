package Balotario;

    public class BusquedaEstudiante {

    public static Alumno buscarMayorNota(Alumno[] alumnos) {

        Alumno alumnoTop = alumnos[0];

        for (int i = 1; i < alumnos.length; i++) {

            if (alumnos[i].getNota() > alumnoTop.getNota()) {

                alumnoTop = alumnos[i];

            }

        }

        return alumnoTop;

    }

    public static void main(String[] args) {

        Alumno[] listaAlumnos = new Alumno[5];//Creamos un arreglo de espacio 5

        // Inicializamos los 5 objetos

        listaAlumnos[0] = new Alumno("Carlos", 14.5);

        listaAlumnos[1] = new Alumno("Maria", 18.0);

        listaAlumnos[2] = new Alumno("Jorge", 15.0);

        listaAlumnos[3] = new Alumno("Ana", 19.5);

        listaAlumnos[4] = new Alumno("Luis", 16.0);

        System.out.println("--- SISTEMA DE BÚSQUEDA ACADÉMICA ---");

        Alumno destacado = buscarMayorNota(listaAlumnos);

        System.out.println("Búsqueda finalizada. El alumno con la mayor nota es:");

        System.out.println(destacado.toString());

    }

}

