/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp4;

import java.util.Scanner;

/**
EJERCICIO 3
Codifique un programa que solicite un valor entero X mayor o igual a 3 y menor o
igual a 10. Cree un arreglo de tamaño [X,X] de tipo int. Posteriormente solicite los

Arreglos Multidimensionales.
valores necesarios para cargar cada una de las celdas de la matriz. Muestre por
pantalla la matriz resultante.
Al finalizar la carga sume cada una de las columnas del array y asigne los resultados
en una nueva matriz de una dimensión, finalmente sume los valores de esta última
matriz y muestre el resultado por pantalla.
Ejemplo: X=5
3 5 8 88 7
45 34 67 87 54
34 43 23 44 55
6 0 45 4 66
56 44 32 12 54
144 126 175 235 236
Total: 916
 */
public class ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar un valor entero X entre 3 y 10
        int X;
        do {
            System.out.print("Ingrese un valor entero X (3 <= X <= 10): ");
            X = scanner.nextInt();
        } while (X < 3 || X > 10);

        // Crear la matriz de tamaño [X, X]
        int[][] matriz = new int[X][X];
        
        // Llenar la matriz
        System.out.println("Ingrese los valores para la matriz:");
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < X; j++) {
                System.out.print("Elemento [" + i + "," + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        // Mostrar la matriz resultante
        System.out.println("\nMatriz resultante:");
        printMatriz(matriz);

        // Sumar cada columna y asignar los resultados en una nueva matriz de una dimensión
        int[] sumaColumnas = new int[X];
        for (int j = 0; j < X; j++) {
            for (int i = 0; i < X; i++) {
                sumaColumnas[j] += matriz[i][j];
            }
        }

        // Sumar los valores de la matriz de sumas
        int total = 0;
        for (int suma : sumaColumnas) {
            total += suma;
        }

        // Mostrar los resultados
        System.out.println("\nSuma de cada columna:");
        for (int i = 0; i < X; i++) {
            System.out.println("Columna " + (i + 1) + ": " + sumaColumnas[i]);
        }

        System.out.println("Total: " + total);

        scanner.close();
    }

    private static void printMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + "\t");
            }
            System.out.println();
        }
    }
}
