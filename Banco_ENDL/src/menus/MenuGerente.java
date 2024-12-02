package menus;

import operaciones_Bancarias.Banco;
import usuarios.clientes.Cliente;
import usuarios.ejecutivos.Ejecutivo;
import usuarios.gerentes.Gerente;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuGerente {
    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu(Gerente gerente,Banco banco) {
        int respuesta = 0;
        while (respuesta != 13) {
            System.out.println("\nBienvenido " + gerente.nombre);
            System.out.println("""
                    \n---------- MENU DEL GERENTE ----------
                    Gestión de clientes >
                        1.- Registrar un cliente
                        2.- Consultar lista de clientes
                        3.- Buscar cliente por nombre o número de cuenta.
                        4.- Actualizar datos de cliente
                        5.- Dar de baja a un cliente
                    Gestión de empleados >
                        6.- Registrar un ejecutivo
                        7.- Consultar lista de ejecutivos
                        8.- Buscar ejecutivo por nombre o número de cuenta. --Nico Avocado
                        9.- Actualizar datos de ejecutivo
                        10.- Dar de baja a un ejecutivo
                    Gestión de usuarios > 
                        11.- Consultar lista de usuarios
                    Operaciones bancarias >
                        12.- Autorizar tarjeta de credito  --
                        13.- Deposito de tarjeta de débito --Nico Avocado
                        14.- Retiro de tarjeta de débito --Estrella
                        15.- Compra tarjeta debito/credito  --Diego A
                        16.- Retiro tarjeta de credito --
                        17.- Pagar tarjeta de credito --
                    18.- Salir""");
            System.out.print("Elija una opción: ");

            try {
                respuesta = Integer.parseInt(scanner.nextLine());
                if (respuesta < 1 || (respuesta > 17 && respuesta != 18)) {
                    System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero y válido somso.");
            }
            procesarDatosMenu(respuesta,banco);
        }
        return respuesta;
    }

    public void procesarDatosMenu(int respuesta,Banco banco) {
        try {
            String nombre, apellidoP, apellidoM, RFC, CURP, email, sucursal = "Banco";
            boolean band;
            LocalDate fechaRegistro = LocalDate.now();

            switch (respuesta) {
                case 1:
                    System.out.println("** REGISTRO DE CLIENTE **");
                    System.out.print("Nombre del cliente: ");
                    nombre = scanner.nextLine().trim();
                    System.out.print("Apellido Paterno del cliente: ");
                    apellidoP = scanner.nextLine().trim();
                    System.out.print("Apellido Materno del cliente: ");
                    apellidoM = scanner.nextLine().trim();
                    RFC = banco.generarRFC(nombre, apellidoP, apellidoM, fechaRegistro);
                    System.out.print("CURP: ");
                    CURP = scanner.nextLine().trim();
                    System.out.print("Email: ");
                    email = scanner.nextLine().trim();

                    double saldo = 10000;

                    Cliente cliente = new Cliente(
                            banco.generarIdCliente(),
                            nombre,
                            apellidoP,
                            apellidoM,
                            RFC,
                            CURP,
                            email,
                            fechaRegistro,
                            saldo,
                            sucursal
                            //null // Tarjeta ¿?, Nulo ppor ahora
                    );
                    banco.registrarCliente(cliente);
                    break;

                case 2:
                    System.out.println("** LISTA DE CLIENTES **");
                    banco.mostrarClientes();
                    break;
                case 3:
                    System.out.println("Buscar cliente por nombre o número de cuenta.");

                    break;
                case 4:
                    System.out.println("** ACTUALIZAR DATOS DE CLIENTE **");
                    band = false;
                    do {
                        System.out.print("Ingrese el ID del cliente a actualizar: ");
                        String idCliente = scanner.nextLine().trim();
                        Cliente clienteObtenido = banco.obtenerClientePorId(idCliente);

                        if (clienteObtenido == null) {
                            System.out.println("Cliente no encontrado. Intente de nuevo.");
                        } else {
                            banco.actualizarDatosCliente(clienteObtenido);
                            band = true;
                        }
                    } while (!band);
                    break;

                case 5:
                    System.out.println("** DAR DE BAJA UN CLIENTE **");
                    band = false;
                    do {
                        System.out.print("Ingrese el ID del cliente a eliminar: ");
                        String idCliente = scanner.nextLine().trim();
                        Cliente clienteObtenido = banco.obtenerClientePorId(idCliente);

                        if (clienteObtenido == null) {
                            System.out.println("Cliente no encontrado. Intente de nuevo.");
                        } else {
                            banco.darBajaCliente(clienteObtenido.getId());
                            System.out.println("Cliente eliminado exitosamente.");
                            band = true;
                        }
                    } while (!band);
                    break;

                case 6:
                    System.out.println("** REGISTRO DE EJECUTIVO **");
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine().trim();
                    System.out.print("Apellido Paterno: ");
                    apellidoP = scanner.nextLine().trim();
                    System.out.print("Apellido Materno: ");
                    apellidoM = scanner.nextLine().trim();
                    RFC = banco.generarRFC(nombre, apellidoP, apellidoM, fechaRegistro);
                    System.out.print("CURP: ");
                    CURP = scanner.nextLine().trim();
                    System.out.print("Email: ");
                    email = scanner.nextLine().trim();

                    Ejecutivo ejecutivo = new Ejecutivo(
                            banco.generarIdEjecutivo(),
                            nombre,
                            apellidoP,
                            apellidoM,
                            RFC,
                            CURP,
                            email
                    );
                    banco.registrarEjecutivo(ejecutivo);
                    break;

                case 7:
                    System.out.println("** LISTA DE EJECUTIVOS **");
                    banco.mostrarEjecutivos();
                    break;

                case 8:
                    System.out.println("** ACTUALIZAR DATOS DE EJECUTIVO **");
                    band = false;
                    do {
                        System.out.print("Ingrese el ID del ejecutivo a actualizar: ");
                        String idEjecutivo = scanner.nextLine().trim();
                        Ejecutivo ejecutivoObtenido = banco.obtenerEjecutivoPorId(idEjecutivo);

                        if (ejecutivoObtenido == null) {
                            System.out.println("Ejecutivo no encontrado. Intente de nuevo.");
                        } else {
                            banco.actualizarDatosEjecutivo(ejecutivoObtenido);
                            band = true;
                        }
                    } while (!band);
                    break;
                case 9:
                    System.out.println("** DAR DE BAJA UN EJECUTIVO **");
                    band = false;
                    do {
                        System.out.print("Ingrese el ID del ejecutivo a eliminar: ");
                        String idEjecutivo = scanner.nextLine().trim();
                        Ejecutivo ejecutivoObtenido = banco.obtenerEjecutivoPorId(idEjecutivo);

                        if (ejecutivoObtenido == null) {
                            System.out.println("Ejecutivo no encontrado. Intente de nuevo.");
                        } else {
                            banco.darBajaEjecutivo(ejecutivoObtenido.getId());
                            System.out.println("Ejecutivo eliminado exitosamente.");
                            band = true;
                        }
                    } while (!band);
                    break;
                case 10:
                    banco.mostrarUsuarios();
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    System.out.println("Adios");
                    break;
            }
        } catch (Exception e) {
            System.err.println("Ocurrió un error durante la operación: " + e.getMessage());
        }
    }
}
