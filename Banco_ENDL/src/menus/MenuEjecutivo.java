package menus;

import operaciones_Bancarias.Banco;
import usuarios.clientes.Cliente;
import usuarios.ejecutivos.Ejecutivo;

import java.time.LocalDate;
import java.util.Scanner;
// implementar interfaz serializable
public class MenuEjecutivo {
    Scanner scanner = new Scanner(System.in);

    public int mostrarMenu(Ejecutivo ejecutivo,Banco banco) {
        int respuesta = 0;
        while (respuesta != 6) {
            System.out.println("\nBienvenido " + ejecutivo.nombre);
            System.out.println("""
                    \n---------- MENU DEL EJECUTIVO ----------
                    1.- Registrar un cliente
                    2.- Eliminar cliente
                    3.- Consultar Datos
                    4.- 
                    5.- 
                    6.- Salir""");
            System.out.print("Elija una opción: ");
            try {
                respuesta = Integer.parseInt(scanner.nextLine());
                if (respuesta < 1 || (respuesta > 8 && respuesta != 13)) {
                    System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero y válido somso.");
            }
            procesarDatos(respuesta,banco);
        }

        return respuesta;
    }

    public void procesarDatos(int opcion,Banco banco) {
        String sucursal = "Banco";
        switch (opcion) {
            case 1:
                System.out.println("Registrar un cliente");
                System.out.print("Nombre del cliente: ");
                String nombre = scanner.nextLine();
                System.out.print("Apellido Paterno del cliente: ");
                String apellidoP = scanner.nextLine();
                System.out.print("Apellido Materno del cliente: ");
                String apellidoM = scanner.nextLine();
                String RFC = banco.generarRFC(nombre,apellidoP,apellidoM,LocalDate.now());
                System.out.print("CURP: ");
                String CURP = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                //Tarjetas

                Cliente cliente = new Cliente(banco.generarIdCliente(),nombre, apellidoP, apellidoM, RFC, CURP, email, LocalDate.now(),0.0,"d");
                banco.listaClientes.add(cliente);
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
            case 6:
                System.out.println("adios");
                break;
            default:
                System.out.println("No es opcion valida");
        }

    }
}
