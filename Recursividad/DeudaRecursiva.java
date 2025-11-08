package Recursividad;

import java.util.Scanner;

public class DeudaRecursiva {

    // Método recursivo para calcular la deuda con interés compuesto
    public static double calcularDeuda(double monto, double tasa, int meses) {
        if (meses == 0) {
            return monto;  // Caso base: sin más meses, devuelve el monto actual
        } else {
            return calcularDeuda(monto * (1 + tasa), tasa, meses - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el monto inicial de la deuda: ");
        double monto = sc.nextDouble();

        System.out.print("Ingrese la tasa de interés mensual (por ejemplo 0.05 para 5%): ");
        double tasa = sc.nextDouble();

        System.out.print("Ingrese el número de meses: ");
        int meses = sc.nextInt();

        double resultado = calcularDeuda(monto, tasa, meses);
        System.out.printf("El monto total después de %d meses es: %.2f%n", meses, resultado);

        sc.close();
    }
}
