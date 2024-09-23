/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp4;

import java.util.Scanner;

/**
EJERCICIO 1
Crea un programa que pida por pantalla cuatro países y a continuación tres
ciudades de cada uno de estos países. Los nombres de ciudades deben
almacenarse en un array multidimensional cuyo primer índice sea el número
asignado a cada país y el segundo índice el número asignado a cada ciudad. Es decir
el array deberá tener un tamaño de 4x4
Ejemplo de resultados que debe mostrar el programa:
País: Argentina Ciudades: Buenos Aires Cordoba La Plata
País: España Ciudades: Madrid Lugo Sevilla
País: Francia Ciudades: Paris Niza Lyon
País: Italia Ciudades: Roma Napoles Sicilia

 */
public class ejercicio1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[][] paises = new String[4][4]; // Tamaño de 4x4

        // Ingreso de datos
        for (int i = 0; i < 4; i++) {
            System.out.println("Ingrese el país " + i);
            paises[i][0] = scanner.nextLine(); // Guardar el país en la columna 0

            for (int j = 1; j < 4; j++) { // Empezar en 1 para no sobrescribir el país
                System.out.println("Ingrese la ciudad " + (j - 1));
                paises[i][j] = scanner.nextLine(); // Guardar ciudades en las columnas 1, 2 y 3
            }
        }

        // Mostrar los datos ingresados
        for (int i = 0; i < 4; i++) {
            System.out.println("País: " + paises[i][0]); // Mostrar el país

            for (int j = 1; j < 4; j++) { // Mostrar las ciudades correspondientes
                System.out.println("Ciudad " + (j - 1) + ": " + paises[i][j]);
            }
        }
    }
    }

