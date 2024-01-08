<h1 align="center">
    Escuela Politécnica Nacional<br>
    Facultad de Ingeniería en Sistemas<br>
    Metodologías Ágiles<br>
</h1>

### Integrantes - Grupo 3

Guilca Miguel  
Joel Guingla  
Stefano Landázuri  
Juan Pablo Obregon  
Cristofer Paucar  
Kenny Pinchao

# Documento de Prácticas de Codificación

## Convenciones y Prácticas Recomendadas

### Nomenclatura de Variables:

1. **Elementos del juego:**
   - Se utilizará nombres descriptivos para las variables que representan a los elementos del juego.
   - Ejemplo: `rioIzquierda`, `animacionHaciaDerecha`,etc.

2. **Estados del Juego:**
   - Si es necesario se utilizará nombres explicativos en los métodos para representar estados del juego.
   - Ejemplo: `pausa()`, `realizarJugada()`, etc.

### Comentarios:

1. **Comentarios Explicativos:**
   - Se incluirá comentarios explicativos cuando sea necesario para aclarar el propósito de una sección de código.
   - Ejemplo: `// Simula un trabajo de medio segundo`.

### Estructura del Código:

1. **Modularización:**
   - Ejemplo: Separa la lógica del menú principal, la lógica del juego, etc.

2. **Organización de Importaciones:**
   - Se organizará las importaciones de manera lógica y agrúpalas según su origen (paquetes del sistema, bibliotecas externas, tus propios módulos).
   - Ejemplo:
     ```java
     import java.util.*;
     import mi.paquete.clases.*;
     ```

### Control de Versiones:

1. **Comentarios de Confirmación:**
   - Se incluirá comentarios claros al confirmar cambios para explicar el propósito de la confirmación.
   - Ejemplo: `git commit -m "Agregar lógica de movimiento de jugadores"`.

2. **Ramas de desarrollo:**
   - Se utilizará ramas aparte, en las que cada desarrollador podrá probar, arreglar o agregar aspectos de todo tipo al proyecto.
   - Ejemplo: `test-kenny`.
