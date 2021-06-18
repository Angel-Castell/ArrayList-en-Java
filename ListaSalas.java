package ProgramaDPO1_U4_EA_ANCR;

import java.util.*;
import java.util.Scanner;

//Clase para administrar los asientos de cada sala
public class ListaSalas {

    //Arreglo unidimensional del tipo lista para manipular cada sala
    public static ArrayList<int[][]> listaSalas=new ArrayList<int[][]>();
    public static Scanner escaner = new Scanner(System.in);

    //Metodo para ordenar las salas con asientos libres e inhabilitados de acuerdo a los requerimientos sanitarios
    public static void crearSala(int filas, int columnas) {
        int[][] asientosSala = new int[filas][columnas];
        int i, j, contador;

        contador=1;
        for (i = 0; i < asientosSala.length; i++) {
            for (j = 0; j < asientosSala[i].length; j++) {
                asientosSala[i][j]=contador;
                //Contador para enumerar los asientos
                contador++;

                //Condicional para inhabilitar asientos de filas pares
                if (asientosSala[i][0] % 2 == 0) {
                    if (j == 1 || j == 2 || j == 5 || j == 6 || j == 9 || j == 10) {
                        asientosSala[i][j] = 0;
                    }
                }
            }
        }
        //Ciclo for para inhabilitar asientos de filas impares
        for (i = 0; i < asientosSala.length; i++) {
            for (j = 0; j < asientosSala[i].length; j++) {
                if (i % 2 == 0) {
                    if (j == 0 || j == 3 || j == 4 || j == 7 || j == 8 ) {
                        asientosSala[i][j] = 0;
                    }
                }
            }
        }

        //Función para agregar una sala a la lista de salas
        listaSalas.add(asientosSala);
    }

    //Método para mostrar los asientos de una sala
    public static void mostrarSala(int sala){
        int[][] asientosSala =listaSalas.get(sala);

        for (int i = 0; i < asientosSala.length; i++) {
            for (int j = 0; j < asientosSala[i].length; j++) {
                System.out.printf("%-4s",asientosSala[i][j]);
                if(j==10){
                    System.out.print("\n");
                }
            }
        }
    }

    //Método para modificar el éstado de los asientos de una sala
    public static void modificarSala(int asiento, int sala){
        int[][] asientosSala =listaSalas.get(sala);
        boolean cambio=false;

        do {
            int contador=1;
            for (int i = 0; i < asientosSala.length; i++) {
                for (int j = 0; j < asientosSala[i].length; j++) {
                    //Condicional para mostrar que el asiento seleccionado está inhabilitado
                    if (asientosSala[i][j] == 0 && contador == asiento) {
                        System.out.print("\n");
                        mostrarSala(sala);
                        System.out.print("Asiento inhabilitado, elija otro asiento: ");
                        asiento = escaner.nextInt();
                    }
                    //Condicional para mostrar que el asiento seleccionado está ocupado
                    else if (contador == asiento && asientosSala[i][j] == 99) {
                        System.out.print("\n");
                        mostrarSala(sala);
                        System.out.print("Asiento ocupado, elija otro asiento: ");
                        asiento = escaner.nextInt();
                    }
                    //Condicional para asignar un asiento disponible
                    else if (contador == asiento && asientosSala[i][j] == asiento) {
                        asientosSala[i][j] = 99;
                        cambio=true;
                    }
                    contador++;
                }
            }
        }while(cambio==false);
        //Función para modificar el estado de los asientos de la sala correspondiente
        listaSalas.set(sala,asientosSala);
    }

}
