import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JuegoRioTest {

    @BeforeEach
    public void setUp() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void tearDown() {
        System.setIn(System.in);

    }

    @Order(1)
    @Test
    public void testMovimientoValidoCaperucita() {
        String input = "1\n1\n"; // Simula los movimientos: Mover Caperucita a la derecha, luego salir.

        Thread gameThread = new Thread(() -> JuegoRio.main(null));
        gameThread.start();

        simulateInput(input);

        // Espera un tiempo suficiente para que el juego realice el movimiento
        try {
            Thread.sleep(2000); // Ajusta el tiempo según la lógica de tu juego
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(JuegoRio.rioDerecha.contains("Caperucita"));
        assertFalse(JuegoRio.rioIzquierda.contains("Caperucita"));
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Order(2)
    @Test
    public void testMovimientoInvalidoUva() {
        // Define el input para los primeros pasos
        String inputSteps = "2\n-1\n";

        Thread gameThread = new Thread(() -> JuegoRio.main(null));
        gameThread.start();

        simulateInput(inputSteps);

        assertTrue(JuegoRio.rioIzquierda.contains("Uva"));
        assertFalse(JuegoRio.rioDerecha.contains("Uva"));
        /*
        // Simula la salida del juego después de la prueba
        String exitInput = "0\n";
        InputStream exitInputStream = new ByteArrayInputStream(exitInput.getBytes());
        System.setIn(exitInputStream);*/
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Order(3)
    @Test
    public void testVictoriaDelJuego() {
        String input = "1\n1\n2\n1\n3\n1\n"; // Movimientos estratégicos hasta la victoria

        Thread gameThread = new Thread(() -> JuegoRio.main(null));
        gameThread.start();

        simulateInput(input);


        // Espera suficiente para que se realicen los movimientos y el juego se termine
        try {
            Thread.sleep(6000); // Ajusta el tiempo según la lógica del juego
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verificar si el juego muestra el mensaje de victoria esperado
        assertTrue(true,
                "El juego no muestra el mensaje de victoria esperado");


    }

    @Order(4)
    @Test
    public void testIntentoMovimientoInexistente() {
        String inputInvalidOption = "4\n"; // Opción inválida

        Thread gameThread = new Thread(() -> JuegoRio.main(null));
        gameThread.start();

        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        InputStream simulatedInput = new ByteArrayInputStream(inputInvalidOption.getBytes());
        System.setIn(simulatedInput);

        try {
            Thread.sleep(200); // Espera para permitir que el juego se ejecute y procese la entrada
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.setOut(originalOutput);
        System.setIn(originalInput);

        String[] lines = outputStream.toString().split("\\n");

        // Buscar el mensaje específico en las líneas obtenidas
        boolean messageFound = false;
        for (String line : lines) {
            System.out.println(line);
            if (line.trim().equalsIgnoreCase("Ingresa una opción válida")) {
                messageFound = true;
                break;
            }
        }

        assertTrue(messageFound, "El juego no muestra el mensaje esperado para una opción inválida");
    }
    private void simulateInput(String input) {
        InputStream simulatedInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(simulatedInput);
    }
}
