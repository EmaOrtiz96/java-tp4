/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp4;

import java.util.Scanner;

/**
 EJERCICIO 5
Codifique la siguiente matriz de 2 dimensiones, que se corresponde a una máquina
expendedora de golosinas donde la columna 1 es la golosina, la columna 2 el precio
y la columna 3 la cantidad (stock) actual de golosinas
KitKat 32 10
Chicles 2 50
Caramelos de Menta 2 50
Huevo Kinder 25 10
Chetoos 30 10
Twix 26 10
M&M'S 35 10
Papas Lays 40 20
Milkybar 30 10
Alfajor Tofi 20 15
Lata Coca 50 20
Chitos 45 10
Tendremos un pequeño menú con las siguientes opciones:
a. Pedir golosina: pedirá la posición de la golosina que quiera. Esta máquina
tiene golosinas en cada posición, identificados por su fila y columna, que
será lo que introduzca el usuario al pedir una golosina, por ejemplo si el
usuario teclea 2 significa que está pidiendo la golosina que está en la fila 2.
Al seleccionar una golosina debe disminuir la cantidad disponible de la
golosina. En caso de agotar el stock de la golosina deberá informar de la
situación al cliente y solicitarle que seleccione otra golosina.
b. Mostrar golosinas: mostrara todas las golosinas con la cantidad actual
disponible.
c. Rellenar golosinas: esta es una función exclusiva de un técnico por lo que
para su ejecución nos pedirá una contraseña, si el usuario escribe
“AdminXYZ” nos autorizara y pedirá la posición de la golosina y la cantidad a
recargar. La cantidad ingresada se sumara a la cantidad actual existente.
d. Apagar maquina: sale del programa, antes de salir mostrara las ventas
totales durante la ejecución del programa. Es decir la suma de todos los
precios de las golosinas seleccionadas desde el inicio del programa.
 */
public class ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definir la matriz de golosinas: [nombre, precio, stock]
        String[][] golosinas = {
            {"KitKat", "32", "10"},
            {"Chicles", "2", "50"},
            {"Caramelos de Menta", "2", "50"},
            {"Huevo Kinder", "25", "10"},
            {"Chetoos", "30", "10"},
            {"Twix", "26", "10"},
            {"M&M'S", "35", "10"},
            {"Papas Lays", "40", "20"},
            {"Milkybar", "30", "10"},
            {"Alfajor Tofi", "20", "15"},
            {"Lata Coca", "50", "20"},
            {"Chitos", "45", "10"}
        };

        double ventasTotales = 0;

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Pedir golosina");
            System.out.println("2. Mostrar golosinas");
            System.out.println("3. Rellenar golosinas");
            System.out.println("4. Apagar máquina");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Pedir golosina
                    System.out.print("Ingrese la posición de la golosina (0 a " + (golosinas.length - 1) + "): ");
                    int posicion = scanner.nextInt();
                    if (posicion >= 0 && posicion < golosinas.length) {
                        int stock = Integer.parseInt(golosinas[posicion][2]);
                        if (stock > 0) {
                            double precio = Double.parseDouble(golosinas[posicion][1]);
                            ventasTotales += precio; // Agregar a ventas totales
                            stock--;
                            golosinas[posicion][2] = String.valueOf(stock); // Actualizar stock
                            System.out.println("Dispensando " + golosinas[posicion][0] + ". Precio: " + precio);
                        } else {
                            System.out.println("Lo sentimos, " + golosinas[posicion][0] + " se ha agotado.");
                        }
                    } else {
                        System.out.println("Posición no válida.");
                    }
                    break;

                case 2:
                    // Mostrar golosinas
                    System.out.println("\nGolosinas disponibles:");
                    for (int i = 0; i < golosinas.length; i++) {
                        System.out.println(i + ". " + golosinas[i][0] + " - Precio: " + golosinas[i][1] + " - Stock: " + golosinas[i][2]);
                    }
                    break;

                case 3:
                    // Rellenar golosinas
                    System.out.print("Ingrese la contraseña de técnico: ");
                    String contrasena = scanner.next();
                    if (contrasena.equals("AdminXYZ")) {
                        System.out.print("Ingrese la posición de la golosina a rellenar (0 a " + (golosinas.length - 1) + "): ");
                        int posRellenar = scanner.nextInt();
                        if (posRellenar >= 0 && posRellenar < golosinas.length) {
                            System.out.print("Ingrese la cantidad a añadir: ");
                            int cantidad = scanner.nextInt();
                            int stockActual = Integer.parseInt(golosinas[posRellenar][2]);
                            golosinas[posRellenar][2] = String.valueOf(stockActual + cantidad); // Actualizar stock
                            System.out.println("Stock de " + golosinas[posRellenar][0] + " actualizado. Nuevo stock: " + golosinas[posRellenar][2]);
                        } else {
                            System.out.println("Posición no válida.");
                        }
                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }
                    break;

                case 4:
                    // Apagar máquina
                    System.out.println("Apagando máquina...");
                    System.out.println("Ventas totales: " + ventasTotales);
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
