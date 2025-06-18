import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.sena.app.models.Book;

public class LibraryApp {
    private static Scanner sacanner = new Scanner(System.in);
    private static List<Book> library = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = sacanner.nextInt();
            sacanner.nextLine();

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

        sacanner.close();
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
}
