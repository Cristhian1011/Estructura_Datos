/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colas;

/**
 *
 * @author manti
 */
public class ColaApss {

    public static void main(String[] args) {
        cola cola = new cola(5);

        cola.insertar(10);
        cola.insertar(15);
        cola.insertar(20);
        cola.insertar(15);

        System.out.println("ELemento en frente" + cola.FrenteCola());

    }
}
