/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp4;

import java.util.Scanner;

/**
 EJERCICIO 2
 * 
Crea un programa que pida por pantalla 2 valores numéricos enteros X e Y. Cree un
primer array de tamaño [X,Y] de tipo entero y almacene en cada posición un valor
entero que deberá ser ingresado por el usuario. A continuación cree un segundo
array de tamaño [Y,X] y almacene en cada posición un valor entero que deberá ser
ingresado por el usuario. Finalmente cree un tercer array de tamaño [X,Y] que será
el resultante de multiplicar cada una de las posiciones de las filas del array uno por
cada una de las posiciones de las columnas del array 2.
Muestre por pantalla cada uno de los arrays con sus valores.

 */
public class ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el tamaño del primer array
        System.out.println("Ingrese el tamaño de X para el 1er array:");
        int numX = scanner.nextInt();
        
        System.out.println("Ingrese el tamaño de Y para el 1er array:");
        int numY = scanner.nextInt();
        
        // Crear el primer array
        int[][] array1 = new int[numX][numY];
        System.out.println("Ingrese los números del 1er array:");
        for (int i = 0; i < numX; i++) {
            for (int j = 0; j < numY; j++) {
                System.out.print("Elemento [" + i + "," + j + "]: ");
                array1[i][j] = scanner.nextInt();
            }
        }

        // Solicitar el tamaño del segundo array
        System.out.println("Ingrese el tamaño de Y para el 2do array (debe ser igual a numY):");
        int numeroY = scanner.nextInt();
        
        System.out.println("Ingrese el tamaño de X para el 2do array:");
        int numeroX = scanner.nextInt();
        
        // Crear el segundo array
        int[][] array2 = new int[numeroY][numeroX];
        System.out.println("Ingrese los números del 2do array:");
        for (int i = 0; i < numeroY; i++) {
            for (int j = 0; j < numeroX; j++) {
                System.out.print("Elemento [" + i + "," + j + "]: ");
                array2[i][j] = scanner.nextInt();
            }
        }

        // Crear el tercer array para almacenar el resultado
        int[][] array3 = new int[numX][numeroX]; // Resulta en [numX, numeroX]
        for (int i = 0; i < numX; i++) {
            for (int j = 0; j < numeroX; j++) {
                array3[i][j] = 0; // Inicializar el elemento
                for (int k = 0; k < numY; k++) { // numY debe ser el tamaño de la columna del primer array
                    array3[i][j] += array1[i][k] * array2[k][j]; // Multiplicación de matrices
                }
            }
        }

        // Mostrar los arrays
        System.out.println("\nPrimer array [X, Y]:");
        printArray(array1);

        System.out.println("\nSegundo array [Y, X]:");
        printArray(array2);

        System.out.println("\nArray resultante [X, Y]:");
        printArray(array3);

        scanner.close();
    }

    private static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
    
}
