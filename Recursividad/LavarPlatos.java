
package Recursividad;

/**
 *
 * @author manti
 */
public class LavarPlatos {

    // Función recursiva para lavar platos
    public static void lavarPlatos(int platoActual) {

        if (platoActual == 0) {
            System.out.println("✅ Todos los platos estan lavados");
            return;
        }


        System.out.println("🧽 Lavando el plato numero " + platoActual + "...");

      
        lavarPlatos(platoActual - 1);

  
        System.out.println("🍽️ Guardando el plato numero " + platoActual + " en el estante.");
    }

    public static void main(String[] args) {
        int totalPlatos = 5;
        System.out.println("Comenzando a lavar " + totalPlatos + " platos...");
        lavarPlatos(totalPlatos);
    }
}
