import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static ArrayList<String> rioIzquierda = new ArrayList<>(Arrays.asList("Caperucita", "Lobo", "Uva"));
    private static ArrayList<String> rioDerecha = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Caperucita Lobo Uva" + "\\__/--------" + "");

        do {
            realizarJugada();
        } while (verificarJuegoContinuo());
    }

    private static void realizarJugada() {
        System.out.println("\n1. MOVER CAPERUCITA\n2. MOVER UVA\n3. MOVER LOBO\n0. SALIR");
        int opcion;

        do {
            System.out.print("Ingresa tu elección: ");
            opcion = scanner.nextInt();
        } while (opcion < 0 || opcion > 3);

        switch (opcion) {
            case 1:
                mover("Caperucita");
                break;
            case 2:
                mover("Uva");    
                break;
            case 3:
                mover("Lobo");
                break;
            case 0:
                System.exit(0);
                break;
        }
    }

    private static void mover(String actor) {
        int orillaActual = rioIzquierda.indexOf(actor);
        int orillaDestino = orillaActual == 0 ? 1 : 0;
        rioIzquierda.remove(actor);
        rioDerecha.add(actor);
        System.out.println("El personaje " + actor + " ha cruzado el río de la orilla 1 a la orilla 2");
    }

    private static boolean verificarJuegoContinuo() {
        if (rioDerecha.contains("Caperucita") && rioDerecha.contains("Lobo") && rioDerecha.contains("Uva")) {
            System.out.println("¡Todos los personajes han cruzado el río! ¡Fin del juego!");
            return false;
        }
        return true;
    }
}
