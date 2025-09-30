/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista;

/**
 *
 * @author manti
 */
public class Nodo {

    public Object dato;
    public Nodo siguiente;

    public Nodo(Object d) {
        dato = d;
        siguiente = null;
    }

    public void mostrarNodo() {
        System.out.println("{" + dato + "}");
    }
}
