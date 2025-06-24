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
                case 4:
                    buscarLibro();
                    break;
                case 5:
                    actualizarLibro();
                    break;
                case 6:
                    eliminarLibro();
                    break;
                case 7:
                    estadisticasBiblioteca();
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
    System.out.println("4. 🔍 Buscar libro");
    System.out.println("5. ✏️ Actualizar libro");
    System.out.println("6. ❌ Eliminar libro");
    System.out.println("7. 📊 Estadísticas de la biblioteca");
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
        System.out.println("\n--- ✏️ ACTUALIZAR LIBRO ---");

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
        
        System.out.println("¿Qué campo desea actualizar?");
        System.out.println("1. Título");
        System.out.println("2. Fecha de edición");
        System.out.println("3. Editorial");
        System.out.println("4. ISBN");
        System.out.println("5. Autores");
        System.out.println("6. Estado de lectura");
        System.out.println("7. Horas de lectura");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion) {
            case 1:
                System.out.print("Nuevo título: ");
                String nuevoTitulo = scanner.nextLine();
                libro.setTitle(nuevoTitulo);
                break;
            case 2:
                System.out.print("Nueva fecha de edición (YYYY-MM-DD): ");
                String nuevaFecha = scanner.nextLine();
                libro.setEditionDate(nuevaFecha);
                break;
            case 3:
                System.out.print("Nueva editorial: ");
                String nuevaEditorial = scanner.nextLine();
                libro.setEditorial(nuevaEditorial);
                break;
            case 4:
                System.out.print("Nuevo ISBN: ");
                String nuevoIsbn = scanner.nextLine();
                libro.setIsbn(nuevoIsbn);
                break;
            case 5:
                System.out.println("Autores actuales: " + String.join(", ", libro.getAuthors()));
                System.out.print("Nuevos autores (separados por comas): ");
                String nuevosAutoresInput = scanner.nextLine();
                String[] nuevosAutores = nuevosAutoresInput.split(",");
                libro.getAuthors().clear();
                for (String autor : nuevosAutores) {
                    libro.getAuthors().add(autor.trim());
                }
                break;
            case 6:
                System.out.print("¿Está leído? (true/false): ");
                boolean estaLeido = scanner.nextBoolean();
                libro.setReaded(estaLeido);
                if (estaLeido) {
                    System.out.print("Horas de lectura: ");
                    int horasLectura = scanner.nextInt();
                    libro.setTimeReaded(horasLectura);
                } else {
                    libro.setTimeReaded(0); 
                }
                break;
            default:
                System.out.println("Opción no válida.");
        }
        System.out.println("✅ Libro actualizado exitosamente!");
    }

    private static void eliminarLibro(){
        System.out.println("\n--- ❌ ELIMINAR LIBRO ---");

        if (library.isEmpty()){
            System.out.println("❌ No hay libros para eliminar.");
            return;
        }

        mostrarLibrosConIndices();

        System.out.println("seleccione el numero del libro a eliminar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        if (indice < 1 || indice > library.size()) {
        System.out.println("❌ Índice no válido.");
        return;
        }

        Book libro = library.get(indice - 1);
        System.out.print("¿Está seguro de eliminar '" + libro.getTitle() + "'? (s/n): ");
        String confirmacion = scanner.nextLine();

        if (confirmacion.equalsIgnoreCase("s") || confirmacion.equalsIgnoreCase("si")) {
            library.remove(indice - 1);
            System.out.println("✅ Libro eliminado exitosamente!");
        } else {
            System.out.println("❌ Eliminación cancelada.");
        }
    }
    private static void buscarLibro() {
        System.out.println("\\n--- 🔍 BUSCAR LIBRO ---");
        System.out.println("Buscar por:");
        System.out.println("1. Título");
        System.out.println("2. Autor");
        System.out.println("3. ISBN");
        System.out.print("Opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Término de búsqueda: ");
        String termino = scanner.nextLine().toLowerCase();

        List<Book> resultados = new ArrayList<>();

        switch (opcion) {
            case 1: 
                for (Book book : library) {
                    if (book.getTitle().toLowerCase().contains(termino)) {
                        resultados.add(book);
                    }
                }
                break;
            case 2:
                for (Book book : library) {
                    for (String author : book.getAuthors()) {
                        if (author.toLowerCase().contains(termino)) {
                            resultados.add(book);
                            break;
                        }
                    }
                }
                break;
            case 3:
                for (Book book : library) {
                    if (book.getIsbn().toLowerCase().contains(termino)) {
                        resultados.add(book);
                    }
                }
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
    }
    private static void estadisticasBiblioteca() {
        System.out.println("\\n--- 📊 ESTADÍSTICAS DE LA BIBLIOTECA ---");

        if (library.isEmpty()) {
            System.out.println("❌ No hay libros en la biblioteca.");
            return;
        }

        int totalLibros = library.size();
        int librosLeidos = 0;
        int totalHoras = 0;

        for (Book libro : library) {
            if (libro.isReaded()) {
                librosLeidos++;
                totalHoras += libro.getTimeReaded();
            }
        }

        System.out.println("Total de libros: " + totalLibros);
        System.out.println("Libros leídos: " + librosLeidos);
        System.out.println("Horas totales de lectura: " + totalHoras);
        System.out.printf("Promedio de horas por libro leído: %.2f%n", 
        librosLeidos > 0 ? (double) totalHoras / librosLeidos : 0.0);
    }
    private static void initializeLibrary() {
        Book book1 = new Book("Effective Java", "2018-01-01", "Addison-Wesley", "978-0134686097");
        book1.getAuthors().add("Joshua Bloch");
        book1.setReaded(true);
        book1.setTimeReaded(10);
        library.add(book1);

        Book book2 = new Book("Clean Code", "2008-08-01", "Prentice Hall", "978-0132350884");
        book2.getAuthors().add("Robert C. Martin");
        book2.setReaded(false);
        book2.setTimeReaded(0);
        library.add(book2);
    }
}
