package Arreglo_Ordenados;

public class AregloOrdenadoApps {

    public static void main(String[] args) {

        ArregloOrdenado arrOrd;

        int Maxtam = 30;
        arrOrd = new ArregloOrdenado(Maxtam);

        arrOrd.insertar(11);
        arrOrd.insertar(55);
        arrOrd.insertar(66);
        arrOrd.insertar(33);
        arrOrd.insertar(22);
        arrOrd.insertar(44);
        arrOrd.insertar(22);
        arrOrd.insertar(1);
        arrOrd.insertar(77);
        arrOrd.insertar(88);
        arrOrd.insertar(99);
        arrOrd.insertar(0);

        arrOrd.mostrarArreglo();

        long buscaar = 55;
        int posicion;

        posicion = arrOrd.busquedaBinaria(buscaar);
        System.out.println("buscando Numero....");
        if (posicion != 1) {
            System.out.println("EL numero encontrado es: " + buscaar);
        } else {
            System.out.println("No se encontro " + buscaar);
        }

        arrOrd.eliminar(0);
        arrOrd.eliminar(99);
        System.out.println("ELiminado 0 y 99");
        arrOrd.mostrarArreglo();
    }
}
