package menus;

import usuarios.Gerente;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuGerente {
    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu(Gerente gerente) {
        int respuesta = 0;
        while (respuesta != 13) {
            System.out.println("\nBienvenido " + gerente.nombre);
            System.out.println("""
                    \n---------- ACCIONES ----------
                    1.- Registrar un cliente
                    2.- Registrar un empleado
                    3.- Mostrar un cliente
                    4.- Mostrar una empleado
                    5.- Actualizar datos de cliente
                    6.- Actualizar datos de empleado
                    7.- Eliminar cliente
                    8.- Eliminar empleado
                    
                    13.- Salir""");
            System.out.print("Elija una opción: ");
            respuesta = scanner.nextInt();
            return respuesta;
        }
        return 0;
    }

    public void procesarDatosMenu(int respuesta, Gerente gerente, operaciones_Bancarias.Banco banco) {
        switch (respuesta) {
            case 1:
                System.out.println("Registrar un cliente");
                System.out.print("Nombre del cliente: ");
                String nombre = scanner.next();
                System.out.print("Apellido del cliente: ");
                String apellido = scanner.next();
                String RFC = "t";
                String CURP = scanner.next();
                String email = scanner.next();
                LocalDate fechaRegistro = LocalDate.parse(scanner.next());
                String sucursal = scanner.next();
                break;
            case 2:
                System.out.println("Registrar un empleado");
                System.out.print("Nombre: ");
                gerente.nombre = scanner.nextLine();
                System.out.print("Apellido: ");
                gerente.apellido = scanner.nextLine();
                System.out.print("Edad: ");
                break;
            case 3:
                System.out.println("Mostrar un cliente");
                System.out.print("Nombre: ");
        }
    }
}
