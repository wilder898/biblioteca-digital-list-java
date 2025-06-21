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
                    crearLibro();
                    break;
                
                case 2:
                    leerLibros();
                    break;

                case 3:
                    mostrarTablaLibros(library);
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
    System.out.println("2. Consultar Libro");
    System.out.println("3. Mostrar Tabla de Libros");
    System.out.println("0. 🚪 Salir");
    System.out.println("═══════════════════════════════════════");
    System.out.print("Seleccione una opción: ");
    }

    private static void crearLibro() {
        System.out.println("\n--- ➕ CREAR NUEVO LIBRO ---");
    
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

        System.out.println("Autores (separados por comas): ");
        String authorsInput = scanner.nextLine();
        String[] authors = authorsInput.split(",");
        for (String author : authors) {
            newBook.getAuthors().add(author.trim());
        }

        System.out.print("¿Está leído? (true/false): ");
        boolean isReaded = scanner.nextBoolean();
        newBook.setReaded(isReaded);

    if (isReaded) {
        System.out.print("Horas de lectura: ");
        int timeReaded = scanner.nextInt();
        newBook.setTimeReaded(timeReaded);
    }
    
        System.out.println("✅ Libro agregado exitosamente!");
    }

    private static void leerLibros(){
        System.out.println("\n--- 📚 BIBLIOTECA COMPLETA ---");

        if (library.isEmpty()) {
            System.out.println("❌ No hay libros en la biblioteca.");
            return;
        }

        for (Book book : library) {
            System.out.println(book.toString());
        }
    }

    private static void mostrarTablaLibros(List<Book> libros) {
        System.out.println("┌──────────────────────────────────────┬─────────────┬──────────────────┬─────────────────┬──────────────────────────────┬────────┬──────────────┐");
        System.out.println("│ Título                               │ Fecha Ed.   │ Editorial        │ ISBN            │ Autores                      │ Leído  │ Hrs. Lectura │");
        System.out.println("├──────────────────────────────────────┼─────────────┼──────────────────┼─────────────────┼──────────────────────────────┼────────┼──────────────┤");

        for (Book book : libros) {
            //Formatear y mostrar cada libros        
            System.out.printf("│ %-36s │ %-11s │ %-16s │ %-15s │ %-28s │ %-6s │ %-11d │%n",
                    book.getTitle(),
                    book.getEditionDate(),
                    book.getEditorial(),
                    book.getIsbn(),
                    String.join(", ", book.getAuthors()),
                    book.isReaded() ? "Sí" : "No",
                    book.isReaded() ? book.getTimeReaded() : 0);
        }

        System.out.println("└──────────────────────────────────────┴─────────────┴──────────────────┴─────────────────┴──────────────────────────────┴────────┴─────────────┘");
    }

    private static void mostrarLibrosConIndices(){
        System.out.println("📚 Libros disponibles:");
        for (int i = 0; i < library.size(); i++) {
            System.out.println((i + 1) + ". " + library.get(i).getTitle());
        }
    }

    private static void actualizarLibro(){
        System.out.println("\\n--- ✏️ ACTUALIZAR LIBRO ---");

        if (library.isEmpty()) {
            System.out.println("❌ No hay libros para actualizar.");
            return;
        }
        mostrarLibrosConIndices();

        System.out.println("Seleccione el número del libro a actualizar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        if (indice < 1 || indice < library.size()) {
            System.out.println("❌ Índice no válido.");
            return;
        }
        Book libro = library.get(indice - 1);
        //TODO: Implementar menú de campos a actualizar 
    }
}
