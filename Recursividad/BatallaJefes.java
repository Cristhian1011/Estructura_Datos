package Recursividad;

/**
 *
 * @author usuario
 */
public class BatallaJefes {
    static void enfrentarJefes(int nivel, int maxNivel) {
        System.out.println("Nivel " + nivel);
        if (nivel < maxNivel) {
            enfrentarJefes(nivel + 1, maxNivel);
        }
        System.out.println("Retornando al nivel " + nivel);
    }
}
