/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp4;

import java.util.Scanner;

/**
 Codifique un programa que solicite un valor entero X mayor o igual a 4 y menor o
igual a 10. Cree un arreglo de tamaño [X,X] de tipo int, nos piden hacer un menú
con estas opciones:
a) Rellenar TODA la matriz de números, debes pedírselo al usuario.
b) Suma de una fila que se pedirá al usuario (validar que elija una correcta)
c) Suma de una columna que se pedirá al usuario (controlar que elija una
correcta)
d) Sumar la diagonal principal
e) Sumar la diagonal inversa
f) La media de todos los valores de la matriz
IMPORTANTE: hasta que no se haga la primera opción a, el resto de opciones no se
deberán de ejecutar, simplemente mostrar un mensaje que diga que debes
rellenar la matriz. Mostrar por pantalla el resultado de la ejecución de cada una de
las opciones del menú.
 */
public class ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar un valor entero X entre 4 y 10
        int X;
        do {
            System.out.print("Ingrese un valor entero X (4 <= X <= 10): ");
            X = scanner.nextInt();
        } while (X < 4 || X > 10);

        // Crear la matriz de tamaño [X, X]
        int[][] matriz = new int[X][X];
        boolean matrizRellena = false;

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Rellenar la matriz");
            System.out.println("2. Suma de una fila");
            System.out.println("3. Suma de una columna");
            System.out.println("4. Sumar la diagonal principal");
            System.out.println("5. Sumar la diagonal inversa");
            System.out.println("6. Media de todos los valores");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Rellenar la matriz
                    System.out.println("Ingrese los valores para la matriz:");
                    for (int i = 0; i < X; i++) {
                        for (int j = 0; j < X; j++) {
                            System.out.print("Elemento [" + i + "," + j + "]: ");
                            matriz[i][j] = scanner.nextInt();
                        }
                    }
                    matrizRellena = true;
                    break;

                case 2:
                    // Sumar una fila
                    if (!matrizRellena) {
                        System.out.println("Primero debe rellenar la matriz.");
                        break;
                    }
                    System.out.print("Ingrese el número de fila a sumar (0 a " + (X-1) + "): ");
                    int fila = scanner.nextInt();
                    if (fila >= 0 && fila < X) {
                        int sumaFila = 0;
                        for (int j = 0; j < X; j++) {
                            sumaFila += matriz[fila][j];
                        }
                        System.out.println("Suma de la fila " + fila + ": " + sumaFila);
                    } else {
                        System.out.println("Número de fila no válido.");
                    }
                    break;

                case 3:
                    // Sumar una columna
                    if (!matrizRellena) {
                        System.out.println("Primero debe rellenar la matriz.");
                        break;
                    }
                    System.out.print("Ingrese el número de columna a sumar (0 a " + (X-1) + "): ");
                    int columna = scanner.nextInt();
                    if (columna >= 0 && columna < X) {
                        int sumaColumna = 0;
                        for (int i = 0; i < X; i++) {
                            sumaColumna += matriz[i][columna];
                        }
                        System.out.println("Suma de la columna " + columna + ": " + sumaColumna);
                    } else {
                        System.out.println("Número de columna no válido.");
                    }
                    break;

                case 4:
                    // Sumar la diagonal principal
                    if (!matrizRellena) {
                        System.out.println("Primero debe rellenar la matriz.");
                        break;
                    }
                    int sumaDiagonalPrincipal = 0;
                    for (int i = 0; i < X; i++) {
                        sumaDiagonalPrincipal += matriz[i][i];
                    }
                    System.out.println("Suma de la diagonal principal: " + sumaDiagonalPrincipal);
                    break;

                case 5:
                    // Sumar la diagonal inversa
                    if (!matrizRellena) {
                        System.out.println("Primero debe rellenar la matriz.");
                        break;
                    }
                    int sumaDiagonalInversa = 0;
                    for (int i = 0; i < X; i++) {
                        sumaDiagonalInversa += matriz[i][X - 1 - i];
                    }
                    System.out.println("Suma de la diagonal inversa: " + sumaDiagonalInversa);
                    break;

                case 6:
                    // Media de todos los valores
                    if (!matrizRellena) {
                        System.out.println("Primero debe rellenar la matriz.");
                        break;
                    }
                    int sumaTotal = 0;
                    for (int i = 0; i < X; i++) {
                        for (int j = 0; j < X; j++) {
                            sumaTotal += matriz[i][j];
                        }
                    }
                    double media = (double) sumaTotal / (X * X);
                    System.out.println("Media de todos los valores de la matriz: " + media);
                    break;

                case 7:
                    // Salir
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
