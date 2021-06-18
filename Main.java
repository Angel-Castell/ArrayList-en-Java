package ProgramaDPO1_U4_EA_ANCR;

import java.util.Scanner;

public class Main {
    public static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int op, boletos, i, asiento;
        boolean salir = false;

        //Invocación del método crearSala() para crear las 3 salas del cine
        ListaSalas.crearSala(4,11);
        ListaSalas.crearSala(6,11);
        ListaSalas.crearSala(8,11);

        do {
            //Menú de peliculas
            System.out.println("\n*************   MENÚ   ***********************");
            System.out.println("1. Conjuro 3 (Sala 1). ");
            System.out.println("2. Kombat Mortal (Sala 2).");
            System.out.println("3. Raya y el Último Dragon (Sala 3).");
            System.out.println("4. Salir.");

            System.out.print("\nSeleccione la opción numérica del menú de la pelicula que desea ver: ");
            op = entrada.nextInt();

            switch (op) {
                case 1:
                    //Función para seleccionar los asientos
                    seleccionarAsientos(0);
                    break;
                case 2:
                    //Función para seleccionar los asientos
                    seleccionarAsientos(1);
                    break;
                case 3:
                    //Función para seleccionar los asientos
                    seleccionarAsientos(2);
                    break;
                case 4:
                    salir=true;
                    break;
                default:
                    System.out.print("\nSeleccione una opción numérica del 1 al 4");
                    break;
            }

        } while (salir == false);
    }

    //Método para seleccionar asientos
    public static void seleccionarAsientos(int sala) {
        int asiento, boletos;

        System.out.print("Ingrese el número de boletos que desea comprar: ");
        boletos=entrada.nextInt();

        for (int i = 0; i < boletos; i++) {
            System.out.print("\n");
            ListaSalas.mostrarSala(sala);
            System.out.print("Seleccione un asiento: ");
            asiento = entrada.nextInt();
            ListaSalas.modificarSala(asiento, sala);
        }
        System.out.println("\nAsientos seleccionados exitosamente:");
        ListaSalas.mostrarSala(sala);
    }
}