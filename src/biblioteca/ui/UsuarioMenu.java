package biblioteca.ui;

import biblioteca.model.Usuario;
import biblioteca.service.UsuarioService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class UsuarioMenu {

    private final UsuarioService usuarioService;
    private final Scanner scanner;

    public UsuarioMenu() {
        this.usuarioService = new UsuarioService();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            System.out.println();

            switch (opcion) {
                case 1 -> agregarUsuario();
                case 2 -> verUsuarios();
                case 3 -> actualizarUsuario();
                case 4 -> eliminarUsuario();
                case 5 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
            System.out.println();
        } while (opcion != 5);
    }

    private void mostrarMenu() {
        System.out.println("=================================");
        System.out.println("    GESTIÓN DE USUARIOS          ");
        System.out.println("=================================");
        System.out.println("1. Agregar usuario");
        System.out.println("2. Ver usuarios");
        System.out.println("3. Actualizar usuario");
        System.out.println("4. Eliminar usuario");
        System.out.println("5. Salir");
        System.out.println("=================================");
    }

    private void agregarUsuario() {
        System.out.println("--- Agregar Usuario ---");
        String id = leerCadena("ID: ");

        if (usuarioService.buscarPorId(id).isPresent()) {
            System.out.println(" Error: Ya existe un usuario con el ID ingresado.");
            return;
        }

        String nombre = leerCadena("Nombre: ");
        String apellido = leerCadena("Apellido: ");
        Integer edad = leerEntero("Edad: ");
        LocalDate bornDate = leerFecha("Fecha de nacimiento (YYYY-MM-DD): ");

        Usuario nuevoUsuario = new Usuario(id, nombre, apellido, edad, bornDate);
        if (usuarioService.guardar(nuevoUsuario)) {
            System.out.println(" Usuario agregado correctamente.");
        } else {
            System.out.println(" No se pudo agregar el usuario.");
        }
    }

    private void verUsuarios() {
        System.out.println("--- Lista de Usuarios ---");
        List<Usuario> usuarios = usuarioService.obtenerTodos();

        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        usuarios.forEach(u -> System.out.printf(
                "ID: %s | Nombre: %s %s | Edad: %d | Fecha Nacimiento: %s%n",
                u.getId(), u.getNombre(), u.getApellido(), u.getEdad(), u.getBornDate()
        ));
    }

    private void actualizarUsuario() {
        System.out.println("--- Actualizar Usuario ---");
        String id = leerCadena("Ingrese el ID del usuario a actualizar: ");

        var usuarioExistente = usuarioService.buscarPorId(id);
        if (usuarioExistente.isEmpty()) {
            System.out.println(" Error: Usuario no encontrado.");
            return;
        }

        System.out.println("Ingrese los nuevos datos:");
        String nuevoNombre = leerCadena("Nuevo Nombre: ");
        String nuevoApellido = leerCadena("Nuevo Apellido: ");
        Integer nuevaEdad = leerEntero("Nueva Edad: ");
        LocalDate nuevaFecha = leerFecha("Nueva Fecha de nacimiento (YYYY-MM-DD): ");

        Usuario usuarioActualizado = new Usuario(id, nuevoNombre, nuevoApellido, nuevaEdad, nuevaFecha);
        if (usuarioService.actualizar(id, usuarioActualizado)) {
            System.out.println(" Usuario actualizado con éxito.");
        } else {
            System.out.println(" No se pudo actualizar el usuario.");
        }
    }

    private void eliminarUsuario() {
        System.out.println("--- Eliminar Usuario ---");
        String id = leerCadena("Ingrese el ID del usuario a eliminar: ");

        if (usuarioService.eliminar(id)) {
            System.out.println(" Usuario eliminado correctamente.");
        } else {
            System.out.println(" Error: No se encontró ningún usuario con ese ID.");
        }
    }

    // --- Lectura y Validación de Entradas ---

    private String leerCadena(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    private Integer leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(" Error: Debe ingresar un número entero válido.");
            }
        }
    }

    private LocalDate leerFecha(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println(" Error: Formato de fecha inválido. Formato requerido: YYYY-MM-DD.");
            }
        }
    }
}