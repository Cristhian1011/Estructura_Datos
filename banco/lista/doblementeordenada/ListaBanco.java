package banco.lista.doblementeordenada;

/**
 *
 * @author manti
 */
public class ListaBanco {

    class Nodo {

        String cliente;
        Nodo anterior, siguiente;
    }

    private Nodo inicio;

    public ListaBanco() {
        inicio = null;
    }

    void insertar(int posicion, String nombre) {
        if (posicion <= cantidad() + 1) {  // PRIMER REGISTRO
            Nodo nuevo = new Nodo();
            nuevo.cliente = nombre;
            if (posicion == 1) {
                nuevo.siguiente = inicio;
                if (inicio != null) {
                    inicio.anterior = nuevo;
                }
                inicio = nuevo;
            } else if (posicion == cantidad() + 1) {  // ULTIMO REGISTRO
                Nodo actual = inicio;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo;
                nuevo.anterior = actual;
                nuevo.siguiente = null;
            } else { //  REGISTRO DE EN MEDIO O POSTERIOR
                Nodo actual = inicio;
                for (int i = 1; i <= posicion - 2; i++) {
                    actual = actual.siguiente;
                }
                Nodo nodoSiguiente = actual.siguiente;
                actual.siguiente = nuevo;
                nuevo.anterior = actual;
                nuevo.siguiente = nodoSiguiente;
                nodoSiguiente.anterior = nuevo;
            }
        }
    }

    // Extraer desde el inicio (posición 1)
    public String extraerAdelante() {
        if (inicio == null) {
            return null;
        }

        String nombre = inicio.cliente;
        inicio = inicio.siguiente;
        if (inicio != null) {
            inicio.anterior = null;
        }
        return nombre;
    }

    // Extraer desde el final (última posición)
    public String extraerAtras() {
        if (inicio == null) {
            return null;
        }

        Nodo actual = inicio;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        String nombre = actual.cliente;
        if (actual.anterior != null) {
            actual.anterior.siguiente = null;
        } else {
            inicio = null; // solo había un nodo
        }

        return nombre;
    }

    public void borrar(int posicion) {
        if (posicion <= cantidad()) {
            if (posicion == 1) {
                inicio = inicio.siguiente;
                if (inicio != null) {
                    inicio.anterior = null;
                }
            } else {
                Nodo actual = inicio;
                for (int i = 1; i <= posicion - 2; i++) {
                    actual = actual.siguiente;
                }
                Nodo temporal = actual.siguiente;
                temporal = temporal.siguiente;
                actual.siguiente = temporal;
                if (temporal != null) {
                    temporal.anterior = actual;
                }
            }
        }
    }

    public int cantidad() {
        int total = 0;
        Nodo actual = inicio;
        while (actual != null) {
            actual = actual.siguiente;
            total++;
        }
        return total;
    }

    public boolean existe(String nombre) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.cliente.equals(nombre)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public boolean vacia() {
        return inicio == null;
    }

    public void imprimir() {
        if (inicio == null) {
            System.out.println("La lista está vacía");
            return;
        }

        Nodo actual = inicio;
        while (actual != null) {
            if (actual.anterior == null) {
                System.out.print("null <- ");
            }
            System.out.print("[ " + actual.cliente + " ]");
            if (actual.siguiente != null) {
                System.out.print(" <-> ");
            } else {
                System.out.print(" -> null");
            }
            actual = actual.siguiente;
        }

        System.out.println();
    }
}
