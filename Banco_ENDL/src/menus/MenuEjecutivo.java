package menus;

import operaciones_Bancarias.Banco;
import usuarios.clientes.Cliente;

import java.time.LocalDate;
import java.util.Scanner;
// implementar interfaz serializable
public class MenuEjecutivo {
    Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n*** BIEVENIDO ***");
        System.out.println("1. Registrar cliente");
       // System.out.println("2. Eliminar cliente");
        System.out.println("3. Consultar datos ");
        System.out.println("4. Salir ");
// autorizar solicitudes ** Almacenar solicitudes, mostrarlas al gerente, decidir si las acepta, guardar esa informacion y notificar al cliente
        int opcion = scanner.nextInt();
        return opcion;
    }

    public void procesarDatos(int opcion) {
        String sucursal = "Banco";
        switch (opcion) {
            case 1:
                System.out.println("Registrar un cliente");
                System.out.print("Nombre del cliente: ");
                String nombre = scanner.next();
                System.out.print("Apellido Paterno del cliente: ");
                String apellidoP = scanner.next();
                System.out.print("Apellido Materno del cliente: ");
                String apellidoM = scanner.next();
                Banco banco = new Banco();
                String RFC = banco.generarRFC(nombre,apellidoP,apellidoM,LocalDate.now());
                System.out.print("CURP: ");
                String CURP = scanner.next();
                System.out.print("Email: ");
                String email = scanner.next();
                //Tarjetas

                Cliente cliente = new Cliente(nombre, apellidoP, apellidoM, RFC, CURP, email, LocalDate.now(), sucursal, tarjetas);
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
        }

    }
}
