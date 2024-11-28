package menus;

import usuarios.clientes.Cliente;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuEjecutivo {
    Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n*** BIEVENIDO ***");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Eliminar cliente");
        System.out.println("3. Consultar datos ");
        System.out.println("4. Salir ");

        int opcion = scanner.nextInt();
        return opcion;
    }

    public void procesarDatos(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("Seleccionaste la opción de registrar un cliente");
                System.out.println("Ingresa el nombre del cliente");
                String nombre = scanner.nextLine();
                System.out.println("Ingresa el apellido del cliente");
                String apellido = scanner.nextLine();
                System.out.println("Ingresa la CURP del cliente");
                String curp = scanner.nextLine();
                System.out.println("Ingresa el correo del cliente");
                String correo = scanner.nextLine();
                System.out.println("Ingresa la direccion del cliente");
                String direccion = scanner.nextLine();

                LocalDate fechaDeRegistro = LocalDate.now();
                String RFC = "Hacer un random"; //**************
                String sucursal = "Matriz"; // Ver si se quita
                String tarjetaDebito = "Hacer método";
                // crear rfc, fecha de registro y ***sucursal  /// Metodo para crear tarjeta

                Cliente cliente = new Cliente(nombre, apellido, RFC, curp, correo, fechaDeRegistro, sucursal, tarjetaDebito);
                /// guardar en un archivo

                break;

            case 2:
                System.out.println("Seleccionó la opcion de dar de baja un cliente ");
                System.out.println("Ingrese el nombre del cliente a eliminar ");
                String nombreBaja = scanner.nextLine();
                /// método de eliminar
                break;

            case 3:
                System.out.println("Mostrar datos de un cliente");
                System.out.println("Ingrese el nombre del cliente a consultar ");
                String nombreCliente = scanner.nextLine();
                /// metodo para mostrar datos
                break;
            case 4:
                System.out.println("Hasta pronto");
                break;
        }

    }
}
