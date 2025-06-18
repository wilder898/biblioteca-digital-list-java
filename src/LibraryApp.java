import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.sena.app.models.Book;

public class LibraryApp {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Book> library = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Crear libro - En desarrollo");
                    break;
                case 0:
                    System.out.println("¡Gracias por usar la biblioteca!");
                    break;
                    default:
                        System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu(){
        System.out.println("\\n═══════════════════════════════════════");
    System.out.println("           BIBLIOTECA DIGITAL");
    System.out.println("═══════════════════════════════════════");
    System.out.println("1. ➕ Crear nuevo libro");
    System.out.println("0. 🚪 Salir");
    System.out.println("═══════════════════════════════════════");
    System.out.print("Seleccione una opción: ");
    }

    private static void crearLibro() {
        System.out.println("\\n--- ➕ CREAR NUEVO LIBRO ---");
    
        System.out.print("Título: ");
        String title = scanner.nextLine();
    
        System.out.print("Fecha de edición (YYYY-MM-DD): ");
        String editionDate = scanner.nextLine();
    
        System.out.print("Editorial: ");
        String editorial = scanner.nextLine();
    
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
    
        Book newBook = new Book(title, editionDate, editorial, isbn);
        library.add(newBook);
    
        System.out.println("✅ Libro agregado exitosamente!");
    }
}
