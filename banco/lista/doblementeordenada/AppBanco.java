/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco.lista.doblementeordenada;

/**
 *
 *
 * @author manti
 */
import java.util.Scanner;

public class AppBanco {

    public static void main(String[] args) {
        ListaBanco turnos = new ListaBanco();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 8) {
            System.out.println("******************************");
            System.out.println("*        MENU BANCO          *");
            System.out.println("******************************");
            System.out.println("* 1. Insertar cliente        *");
            System.out.println("* 2. Borrar cliente          *");
            System.out.println("* 3. Extraer ultimo o primero de la fila         *");
            System.out.println("* 4. Imprimir turnos         *");
            System.out.println("* 5. Buscar cliente          *");
            System.out.println("* 6. Verificar lista vacia   *");
            System.out.println("* 7. Verificar cunatos clientes hay en la fila   *");
            System.out.println("* 8. Salir                   *");
            System.out.println("******************************");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese posicion: ");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String nombre = sc.nextLine();
                    turnos.insertar(pos, nombre);
                    break;
                case 2:
                    System.out.print("Ingrese posicion a borrar: ");
                    int posBorrar = sc.nextInt();
                    turnos.borrar(posBorrar);
                    break;
                case 3:
                    System.out.println("¿A quien desea extraer?");
                    System.out.println("1. Al primero de la fila");
                    System.out.println("2. Al ultimo de la fila");
                    int opcionExtraer = sc.nextInt();
                    sc.nextLine(); // Limpiar buffer
                    String extraido = null;

                    if (opcionExtraer == 1) {
                        extraido = turnos.extraerAdelante();
                        System.out.println("El cliente " + extraido + " fue extraído de la fila");

                    } else if (opcionExtraer == 2) {
                        extraido = turnos.extraerAtras();
                        System.out.println("El cliente " + extraido + " fue extraído de la fila");

                    } else {
                        System.out.println("Opción inválida");
                    }
                    break;

                case 4:
                    System.out.println("Turnos actuales:");
                    turnos.imprimir();
                    break;
                case 5:
                    System.out.print("Ingrese nombre a buscar: ");
                    String buscar = sc.nextLine();
                    if (turnos.existe(buscar)) {
                        System.out.println("El cliente " + buscar + " esta en la fila");
                    } else {
                        System.out.println("El cliente " + buscar + " no esta en la fila");
                    }
                    break;
                case 6:
                    if (turnos.vacia()) {
                        System.out.println("La fila esta vacia");
                    } else {
                        System.out.println("La fila tiene clientes");
                    }
                    break;
                case 7:
                    if (turnos.vacia()) {
                        System.out.println("La fila esta vacia");
                    } else {
                        System.out.println("La fila tiene " + turnos.cantidad() + " clientes");
                    }

                case 8:
                    System.out.println("******************************");
                    System.out.println("*    Programa finalizado     *");
                    System.out.println("******************************");
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo");
            }
        }
        sc.close();
    }
}
