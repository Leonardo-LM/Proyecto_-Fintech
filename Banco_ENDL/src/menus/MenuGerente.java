package menus;

import operaciones_Bancarias.Banco;
import usuarios.clientes.Cliente;
import usuarios.ejecutivos.Ejecutivo;
import usuarios.gerentes.Gerente;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuGerente {
    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu(Gerente gerente) {
        int respuesta=0;
        while (respuesta != 13) {
            System.out.println("\nBienvenido " + gerente.nombre);
            System.out.println("""
                        \n---------- ACCIONES ----------
                        1.- Registrar un cliente
                        2.- Registrar un ejecutivo
                        3.- Mostrar lista de clientes
                        4.- Mostrar lista de ejecutivos
                        5.- Actualizar datos de cliente
                        6.- Actualizar datos de ejecutivo
                        7.- Eliminar cliente
                        8.- Eliminar ejecutivo
                      
                        13.- Salir""");
            System.out.print("Elija una opción: ");
            respuesta = scanner.nextInt();
            return respuesta;
        }
        return 0;
    }

    public void procesarDatosMenu(int respuesta, Gerente gerente, Banco banco){
        String nombre = "", apellidoP = "", apellidoM ="", RFC = "", CURP = "", email = "", sucursal = "Banco";
        LocalDate fechaRegistro = LocalDate.now();
        switch (respuesta) {
            case 1:
                System.out.println("Registrar un cliente");
                System.out.print("Nombre del cliente: ");
                nombre = scanner.next();
                System.out.print("Apellido Paterno del cliente: ");
                apellidoP = scanner.next();
                System.out.print("Apellido Materno del cliente: ");
                apellidoM = scanner.next();
                RFC = banco.generarRFC(nombre,apellidoP,apellidoM,LocalDate.now());
                System.out.print("CURP: ");
                CURP = scanner.next();
                System.out.print("Email: ");
                email = scanner.next();
                //Tarjetas

                Cliente cliente = new Cliente(nombre, apellidoP, apellidoM, RFC, CURP, email, fechaRegistro, sucursal, tarjetas);
                banco.listaClientes.add(cliente);
                break;
            case 2:
                System.out.println("Registrar un ejecutivo");
                System.out.print("Nombre: ");
                nombre = scanner.nextLine();
                System.out.print("Apellido Paterno: ");
                apellidoP = scanner.nextLine();
                System.out.print("Apellido Materno: ");
                apellidoM = scanner.nextLine();
                RFC = banco.generarRFC(nombre,apellidoP,apellidoM,LocalDate.now());
                System.out.print("CURP: ");
                CURP = scanner.next();
                System.out.print("Email: ");
                email = scanner.next();

                Ejecutivo ejecutivo = new Ejecutivo(nombre, apellidoP, apellidoM, RFC, CURP, email);
                banco.listaEjecutivos.add(ejecutivo);
                break;
            case 3:
                System.out.println("Mostrar un cliente");
                System.out.print("Nombre: ");
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
        }
    }

}
