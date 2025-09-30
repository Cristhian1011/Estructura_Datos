package Pilas;

public class Pila {

    private Object[] arregloPila;
    private int TamaPila;
    private int Cima;

    public Pila(int TamaPila) {
        this.TamaPila = TamaPila;
        Cima = -1;
        arregloPila = new Object[TamaPila];
    }

    public void insertarPila(Object Dato) {
        Cima += 1;
        arregloPila[Cima] = Dato;
    }

    public Object quitarElemnt() {
        Object temp = arregloPila[Cima];
        Cima -= 1;
        return temp;
    }

    public Object cimaPila() {
        return arregloPila[Cima];
    }

    public boolean pilaLlena() {
        return Cima == TamaPila - 1;
    }

    public int tmanio() {
        return Cima + 1;
    }

    public void mostrarELementosPil() {
        for (int i = 0; i < tmanio(); i++) {
            System.out.println(arregloPila[i]);
            System.out.println("");
        }
    }
}
