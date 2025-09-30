package ListaGenericaDoblementeEnlazada;

//Clase principal de la Lista
public class Lista {
    private Nodo inicio;
    private Nodo fin;
    
    public Lista(){
        inicio = null;
        fin = null;
    }
// ---------------- Cantidad de nodos ----------------
    public int cantidad() {
        int contador = 0;
        Nodo actual = inicio;
        while (actual != null) {
            contador++;
            actual = actual.sig;
        }
        return contador;
    }
    
//----------------------- Agregar un video al inicio y al final ------------------------------
    public void agregarI(int video, String titulo, int duracion){
        Nodo a = new Nodo(video, titulo, duracion);
        if (inicio == null) { // Comprobar si la lista esta vacia
            inicio = fin = a;
        } else {
            a.sig = inicio;
            inicio.prev = a;
            inicio = a;
        }
    }
    
    public void agregarF(int video, String titulo, int duracion){ 
        Nodo a = new Nodo(video, titulo, duracion);
        if (inicio == null){
            inicio = fin = a;
        } else {
            fin.sig = a;
            a.prev = fin;
            fin = a;
        }
    }
    
//-------------------------------- Eliminar un video ---------------------------------------
    public void eliminarVideo(int pos) {
        if (pos <= cantidad()) { // verificar que la posición exista
            if (pos == 1) { // eliminar el primero
                inicio = inicio.sig;
                if (inicio != null) {
                    inicio.prev = null;
                } else {
                    fin = null; // si se borró el único nodo
                }
            } else {
                Nodo ant = inicio;
                for (int i = 1; i <= pos - 2; i++) {
                    ant = ant.sig;
                }
                Nodo prox = ant.sig;
                prox = prox.sig;
                ant.sig = prox;
                if (prox != null) {
                    prox.prev = ant;
                } else {
                    fin = ant; // si borramos el último
                }
            }
        }
    }
//--------------------------------- Recorrer la lista -------------------------------------
    public void recorrerAdelante() {
    Nodo actual = inicio;
    while (actual != null) {
        System.out.println("ID: " + actual.getVideo() +
                           " | Titulo: " + actual.getTitulo() +
                           " | Duracion: " + actual.getDuracion() + " min");
        actual = actual.sig; // pasar al siguiente
        }
    }
    public void recorrerAtras() {
    Nodo actual = fin;
    while (actual != null) {
        System.out.println("ID: " + actual.getVideo() +
                           " | Titulo: " + actual.getTitulo() +
                           " | Duracion: " + actual.getDuracion() + " min");
        actual = actual.prev; // pasar al siguiente
        }
    }
}

