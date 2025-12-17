package app;
import model.Persona; // IMPORTANTE: Traemos la clase Persona desde su paquete
import java.util.Scanner; // Para leer del teclado
import java.io.FileWriter; // Para escribir en ficheros
import java.io.IOException; // Para manejar errores de escritura
public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

        // 1. PEDIR DATOS AL USUARIO
        System.out.println("=== GENERADOR DE TARJETAS DE PRESENTACIÓN ===");
        
        String nombreUsuario = "";
        
        do {
        	System.out.println("Escribe tu nombre completo (obligatorio): ");
        	nombreUsuario = scanner.nextLine();
        	
        	if (nombreUsuario.isBlank()) {
        		System.out.println("Error, el campo no puede estar vacio");
        	}
        } while (nombreUsuario.isBlank());
        
        System.out.print("Introduce tu profesión: ");
        String profesionUsuario = scanner.nextLine();
        
        System.out.print("Escribe una breve descripción sobre ti: ");
        String descripcionUsuario = scanner.nextLine();
        
        System.out.println("Que color de fondo quieres? (Red, blue, yellow...)");
        String colorFondo = scanner.nextLine();
        
        System.out.println("Añade tu linkedin para contactar:");
        String contactoLinkedin = scanner.nextLine();
        
        
        
        // 2. CREAR EL OBJETO (Instanciar la clase)
        // Aquí usamos el constructor que creaste en Persona.java
        Persona miPersona = new Persona(nombreUsuario, profesionUsuario, descripcionUsuario, colorFondo, contactoLinkedin);

        // 3. GENERAR EL HTML Y GUARDARLO
        // El método generarHTML() nos devuelve el String gigante
        String codigoHtml = miPersona.generarHTML();

        // Ahora usamos un bloque "try-catch" para guardar el archivo.
        // Esto es necesario siempre que tocas ficheros por si falla el disco duro, permisos, etc.
        try {
            // Creamos el archivo "index.html" en la carpeta raíz del proyecto
            FileWriter escritor = new FileWriter("index.html");
            
            escritor.write(codigoHtml); // Escribimos el código dentro
            escritor.close(); // Cerramos el fichero para guardar cambios
            
            System.out.println("-------------------------------------------------");
            System.out.println("¡ÉXITO! Tu tarjeta ha sido generada.");
            System.out.println("Busca el archivo 'index.html' en la carpeta de tu proyecto.");
            System.out.println("-------------------------------------------------");
            
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo: " + e.getMessage());
        }
        
        scanner.close();
    }
}