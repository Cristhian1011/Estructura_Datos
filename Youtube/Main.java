package ListaGenericaDoblementeEnlazada;

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();

        // Agregar videos al final
        lista.agregarF(1, "Intro al canal", 5);
        lista.agregarF(2, "Top 10 goles", 12);
        lista.agregarF(3, "Tutorial Java", 20);
        lista.agregarF(4, "Final de temporada", 15);

        System.out.println("Lista completa (adelante):");
        lista.recorrerAdelante();

        System.out.println("\nLista completa (atras):");
        lista.recorrerAtras();

        // Eliminar un video
        lista.eliminarVideo(2);

        System.out.println("\nLista despues de eliminar el video 2:");
        lista.recorrerAdelante();

        // Agregar un video al inicio
        lista.agregarI(5, "Nuevo trailer", 8);

        System.out.println("\nLista final:");
        lista.recorrerAdelante();
    }
}
