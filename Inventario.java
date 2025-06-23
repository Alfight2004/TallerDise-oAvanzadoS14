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
        String nombre;
        String clase;
        int mana;
        int ataque;
        int vida;

        // Validar nombre
        while (true) {
            System.out.print("Nombre de la carta: ");
            nombre = scanner.nextLine().trim();
            if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                break;
            } else {
                System.out.println("❌ El nombre solo puede contener letras y espacios.");
            }
        }

        // Validar clase
        while (true) {
            System.out.print("Clase de la carta (ej. Mago, Guerrero): ");
            clase = scanner.nextLine().trim();
            if (clase.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                break;
            } else {
                System.out.println("❌ La clase solo puede contener letras y espacios.");
            }
        }

        // Validar maná
        while (true) {
            System.out.print("Costo de maná: ");
            try {
                mana = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("❌ Debes ingresar un número entero.");
            }
        }

        // Validar ataque
        while (true) {
            System.out.print("Ataque: ");
            try {
                ataque = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("❌ Debes ingresar un número entero.");
            }
        }

        // Validar vida
        while (true) {
            System.out.print("Vida: ");
            try {
                vida = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("❌ Debes ingresar un número entero.");
            }
        }

        Carta carta = new Carta(nombre, clase, mana, ataque, vida);
        cartas.put(nombre.toLowerCase(), carta);
        System.out.println("✅ Carta agregada con éxito.");
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
        String nombre = scanner.nextLine().trim().toLowerCase();

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
        String nombre = scanner.nextLine().trim().toLowerCase();

        if (cartas.containsKey(nombre)) {
            cartas.remove(nombre);
            System.out.println("🗑️ Carta eliminada.");
        } else {
            System.out.println("❌ La carta no existe.");
        }
    }
}
