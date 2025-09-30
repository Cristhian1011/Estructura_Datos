/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colas;

/**
 *
 * @author manti
 */
public class cola {

    private Object[] colaArr;
    private int tamanioMax;
    private int frente;
    private int fin;
    private int NumElemns;

    public cola(int tamani) {
        tamanioMax = tamani;
        colaArr = new Object[tamanioMax];

        fin = -1;
        frente = 0;
        NumElemns = 0;
    }

    public void insertar(Object Elemento) {
        if (fin == tamanioMax - 1) {
            fin = -1;
        } else {
            fin++;
            colaArr[fin] = Elemento;
            NumElemns++;

        }
    }

    public Object Eliminar() {
        Object temp = colaArr[frente];
        frente += 1;

        if (frente == tamanioMax) {
            frente = 0;
        }
        NumElemns--;
        return temp;
    }

    public Object FrenteCola() {
        return colaArr[frente];
    }

    public Object colaVacia() {
        return (NumElemns == 0);

    }

    public Object colaLLena() {
        return (NumElemns == tamanioMax);

    }

    public Object tamanioCola() {
        return NumElemns;
    }

}
