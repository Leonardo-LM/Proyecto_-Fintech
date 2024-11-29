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
                        7.- Dar de baja a un cliente
                        8.- Dar de baja a un ejecutivo
                      
                        13.- Salir""");
            System.out.print("Elija una opción: ");
            respuesta = scanner.nextInt();
            return respuesta;
        }
        return 0;
    }

    public void procesarDatosMenu(int respuesta, Banco banco) {
        String nombre, apellidoP, apellidoM, RFC, CURP, email, sucursal = "Banco";
        boolean band = false;
        LocalDate fechaRegistro = LocalDate.now();
        switch (respuesta) {
            case 1:
                System.out.println("** REGISTRO DE CLIENTES **");
                System.out.print("Nombre del cliente: ");
                nombre = scanner.next();
                System.out.print("Apellido Paterno del cliente: ");
                apellidoP = scanner.next();
                System.out.print("Apellido Materno del cliente: ");
                apellidoM = scanner.next();
                RFC = banco.generarRFC(nombre, apellidoP, apellidoM, LocalDate.now());
                System.out.print("CURP: ");
                CURP = scanner.next();
                System.out.print("Email: ");
                email = scanner.next();
                //Tarjetas

                Cliente cliente = new Cliente(banco.generarIdCliente(), nombre, apellidoP, apellidoM, RFC, CURP, email, fechaRegistro, sucursal, tarjetas);
                banco.listaClientes.add(cliente);
                break;
            case 2:
                System.out.println("** REGISTRO DE EJECUTIVO **");
                System.out.print("Nombre: ");
                nombre = scanner.nextLine();
                System.out.print("Apellido Paterno: ");
                apellidoP = scanner.nextLine();
                System.out.print("Apellido Materno: ");
                apellidoM = scanner.nextLine();
                RFC = banco.generarRFC(nombre, apellidoP, apellidoM, LocalDate.now());
                System.out.print("CURP: ");
                CURP = scanner.next();
                System.out.print("Email: ");
                email = scanner.next();

                Ejecutivo ejecutivo = new Ejecutivo(banco.generarIdEjecutivo(), nombre, apellidoP, apellidoM, RFC, CURP, email);
                banco.listaEjecutivos.add(ejecutivo);
                break;
            case 3:
                //Mostrar lista de clientes
                banco.mostrarClientes();
                break;
            case 4:
                //Mostrar lista de ejecutivos
                banco.mostrarEjecutivos();
                break;
            case 5:
                //Actualizar datos de un cliente
                do {
                    System.out.print("Ingrese el id del cliente del cual actualizar datos: " +
                            "Id: ");
                    Cliente clienteObtenido = banco.obtenerClientePorId(scanner.nextLine());

                    if (clienteObtenido == null) {
                        System.out.println("Cliente no encontrado, intente  de nuevo");
                    } else {
                        banco.actualizarDatosCliente(clienteObtenido);
                        System.out.println("Datos actualizados corrctamente");
                        band =true;
                    }
                }while (!band);
                break;
            case 6:
                //Actualizar datos de un ejecutivo
                do {
                    System.out.print("Ingrese el id del ejecutivo del cual actualizar datos: " +
                            "Id: ");
                    Ejecutivo ejecutivoObtenido = banco.obtenerEjecutivoPorId(scanner.nextLine());

                    if (ejecutivoObtenido == null) {
                        System.out.println("Ejecutivo no encontrado, intente  de nuevo");
                    } else {
                        banco.actualizarDatosEjecutivo(ejecutivoObtenido);
                        System.out.println("Datos actualizados corrctamente");
                        band =true;
                    }
                }while (!band);
                break;
            case 7:
                //Eliminar cliente
                band = false;
                do {
                    System.out.print("Ingrese el id del cliente que desea dar de baja: " +
                            "Id: ");
                    Cliente clienteObtenido = banco.obtenerClientePorId(scanner.nextLine());

                    if (clienteObtenido == null) {
                        System.out.println("Cliente no encontrado, intente  de nuevo");
                    } else {
                        banco.darBajaCliente(clienteObtenido.getId());
                        System.out.println("Cliente eliminado corrctamente");
                        band =true;
                    }
                }while (!band);
                break;
            case 8:
                //Eliminar ejecutivo
                band = false;
                do {
                    System.out.print("Ingrese el id del ejecutivo que desea dar de baja: " +
                            "Id: ");
                    Ejecutivo ejecutivoObtenido = banco.obtenerEjecutivoPorId(scanner.nextLine());

                    if (ejecutivoObtenido == null) {
                        System.out.println("Ejecutivo no encontrado, intente  de nuevo");
                    } else {
                        banco.darBajaEjecutivo(ejecutivoObtenido.getId());
                        System.out.println("Ejecutivo eliminado corrctamente");
                        band =true;
                    }
                }while (!band);
                break;
        }
    }


}
