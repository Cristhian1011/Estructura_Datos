//freydder said listas genericas doblemente encadenadas:
class Nodo<T> {
    T dato;
    Nodo<T> siguiente;
    Nodo<T> anterior;

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}

class ListaDoble<T> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;

    public ListaDoble() {
        cabeza = null;
        cola = null;
    }

    // 1. Agregagamos estudiante al inicio
    public void agregarAlInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
    }

    // 2. Agregamos estudiante al final
    public void agregarAlFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    // 3. Eliminar estudiante (por dato)
    public void eliminar(T dato) {
        if (cabeza == null) {
            System.out.println("La lista esta vacia, no se puede eliminar.");
            return;
        }

        Nodo<T> actual = cabeza;

        while (actual != null) {
            if (actual.dato.equals(dato)) {
                // este caso:es la cabeza
                if (actual == cabeza) {
                    cabeza = cabeza.siguiente;
                    if (cabeza != null) {
                        cabeza.anterior = null;
                    } else {
                        cola = null; // lista quedó vacía
                    }
                }
                // este caso: es la cola
                else if (actual == cola) {
                    cola = cola.anterior;
                    cola.siguiente = null;
                }
                // y este caso: está en medio
                else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                }
                System.out.println("Se elimino: " + dato);
                return;
            }
            actual = actual.siguiente;
        }
        System.out.println("No se encontro el estudiante: " + dato);
    }

    // 3. Recorrer de inicio a fin
    public void mostrarInicioAFin() {
        Nodo<T> actual = cabeza;
        System.out.print("Lista (inicio - fin): ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // 3. Recorrer de fin a inicio
    public void mostrarFinAInicio() {
        Nodo<T> actual = cola;
        System.out.print("Lista (fin - inicio): ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.anterior;
        }
        System.out.println();
    }
}

public class GestionEstudiantes {
    public static void main(String[] args) {
        // Lista genérica de tipo String para nombres de estudiantes
        ListaDoble<String> lista = new ListaDoble<>();

        
        lista.agregarAlFinal("Carlos-");
        lista.agregarAlFinal("Maria-");
        lista.agregarAlInicio("Delegado: Andres-");
        lista.agregarAlFinal("Lucia-");

        lista.mostrarInicioAFin();
        lista.mostrarFinAInicio();

    
        lista.eliminar("Carlos-");
        lista.mostrarInicioAFin();

        lista.eliminar("Pedro");
    }
}
