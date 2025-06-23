import java.util.HashMap;
import java.util.Scanner;

public class Inventario {
    private HashMap<String, Carta> cartas = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("\n--- INVENTARIO DE CARTAS DE HEARTHSTONE ---");
            System.out.println("1. Agregar carta");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Buscar carta");
            System.out.println("4. Eliminar carta");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        agregarCarta();
                        break;
                    case 2:
                        mostrarCartas();
                        break;
                    case 3:
                        buscarCarta();
                        break;
                    case 4:
                        eliminarCarta();
                        break;
                    case 5:
                        System.out.println("👋 Saliendo del programa...");
                        break;
                    default:
                        System.out.println("❌ Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Debe ingresar un número.");
            }

        } while (opcion != 5);
    }

    private void agregarCarta() {
        try {
            System.out.print("Nombre de la carta: ");
            String nombre = scanner.nextLine().trim();
            if (nombre.isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío.");
            }

            System.out.print("Clase de la carta (ej. Mago, Guerrero): ");
            String clase = scanner.nextLine().trim();

            System.out.print("Costo de maná: ");
            int mana = Integer.parseInt(scanner.nextLine());

            System.out.print("Ataque: ");
            int ataque = Integer.parseInt(scanner.nextLine());

            System.out.print("Vida: ");
            int vida = Integer.parseInt(scanner.nextLine());

            Carta carta = new Carta(nombre, clase, mana, ataque, vida);
            cartas.put(nombre, carta);

            System.out.println("✅ Carta agregada con éxito.");

        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Debe ingresar un número válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }

    private void mostrarCartas() {
        if (cartas.isEmpty()) {
            System.out.println("📭 El inventario está vacío.");
        } else {
            for (Carta carta : cartas.values()) {
                System.out.println(carta);
            }
        }
    }

    private void buscarCarta() {
        System.out.print("Nombre de la carta a buscar: ");
        String nombre = scanner.nextLine().trim();

        Carta carta = cartas.get(nombre);
        if (carta != null) {
            System.out.println("🔍 Carta encontrada:");
            System.out.println(carta);
        } else {
            System.out.println("❌ Carta no encontrada.");
        }
    }

    private void eliminarCarta() {
        System.out.print("Nombre de la carta a eliminar: ");
        String nombre = scanner.nextLine().trim();

        if (cartas.containsKey(nombre)) {
            cartas.remove(nombre);
            System.out.println("🗑️ Carta eliminada.");
        } else {
            System.out.println("❌ La carta no existe.");
        }
    }
}
