package Pilas;

public class PilaApp {

    public static void main(String[] args) {
        Pila pila = new Pila(5);

        pila.insertarPila(20);
        pila.insertarPila(30);
        pila.insertarPila(40);
        pila.insertarPila(50);
        pila.insertarPila(60);

        System.out.println("Elementos de la pila: ");
        pila.mostrarELementosPil();

        System.out.println("");
        System.out.println("");
        System.out.println("Elemeneno en la cima de la pila " + pila.cimaPila());

        System.out.println("");
        System.out.println("EL tamanio de la pila es " + pila.tmanio());
    }
}
