package menus;

import operaciones_Bancarias.Banco;
import tarjetas.Debito;
import usuarios.Usuario;
import usuarios.clientes.Cliente;
import usuarios.ejecutivos.Ejecutivo;
import usuarios.gerentes.Gerente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MenuGerente {
    private final Scanner scanner = new Scanner(System.in);
   //public Banco banco = new Banco();
    public int mostrarMenu(Gerente gerente,Banco banco) {
        int respuesta = 0;
        while (respuesta != 19) {
            System.out.println("\nBienvenido " + gerente.nombre);
            System.out.println("""
                    \n---------- MENU DEL GERENTE ----------
                    Gestión de clientes >
                        1.- Registrar un cliente
                        2.- Consultar lista de clientes
                        3.- Buscar cliente por Id.
                        4.- Actualizar datos de cliente
                        5.- Dar de baja a un cliente
                    Gestión de empleados >
                        6.- Registrar un ejecutivo
                        7.- Consultar lista de ejecutivos
                        8.- Buscar ejecutivo por Id
                        9.- Actualizar datos de ejecutivo
                        10.- Dar de baja a un ejecutivo
                    Gestión de usuarios >
                        11.- Consultar lista de usuarios
                    Operaciones bancarias >
                        12.- Autorizar tarjeta de credito 
                        13.- Deposito de tarjeta de débito
                        14.- Retiro de tarjeta de débito 
                        15.- Compra tarjeta debito/credito  
                        16.- Retiro tarjeta de credito 
                        17.- Pagar tarjeta de credito 
                        18.-Mostrar Tarjetas Debito
                    19.- Salir""");
            System.out.print("Elija una opción: ");
             respuesta = scanner.nextInt();
            try {
                respuesta = Integer.parseInt(scanner.nextLine());
                if (respuesta < 1 || respuesta > 19) {
                    System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero y válido somso.");
            }
            procesarDatosMenu(respuesta,banco,gerente);
        }
        return respuesta;
    }


    public void procesarDatosMenu(int respuesta,Banco banco, Gerente gerente) {
        try {
            String nombre, apellidoP, apellidoM, RFC, CURP, email, sucursal = "Banco";
            boolean band;
            LocalDate fechaRegistro = LocalDate.now();

            switch (respuesta) {
                case 1:
                    System.out.println("** REGISTRO DE CLIENTES **");
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
                    );
                    banco.registrarCliente(cliente);
                    banco.generarTarjetaDebito(cliente);
                    break;
                case 2:
                    System.out.println("** CONSULTAR LISTA DE CLIENTES **");
                    banco.mostrarClientes();
                    break;

                case 3:
                    System.out.println("** BUSCAR CLIENTE POR SU ID. **");
                    System.out.println("Ingresa el id del cliente que desea buscar: ");
                    String idClienteBusqueda = scanner.next();

                    banco.mostrarClientePorId(idClienteBusqueda);
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

                    break;
                case 10:
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
                case 11:
                    banco.mostrarUsuarios();
                    break;
                case 12:
                    System.out.println("Autorizar tarjeta de credito");
                    banco.mostrarSolitudes();
                    banco.autorizarTarjetaCredito();
                    break;
                case 13:
                    System.out.println("Hola Bienvenido al sistema de deposito a tu tarjeta de Debito");
                    System.out.println("Ingresa el No de tarjeta a depositar");
                    String NoTarjeta=scanner.nextLine().trim();
                    Debito x=banco.validarTarjeta(NoTarjeta);
                    if (x != null) {
                        System.out.println("Tarjeta encontrada: " + x.getNumeroTarjeta());
                        Cliente persona=x.getTitular();
                        String name=persona.getNombre();
                        System.out.println("El titular es: " + name);
                        System.out.println("Ingresa la catidad a depositar");
                        double dinero= scanner.nextDouble();
                        double saldonuevo=x.getSaldo()+dinero;
                        System.out.println("Ingresa 1 Acreditar la operacion de lo contario se cancelara");
                        scanner.nextLine();
                        String confirmacion=scanner.nextLine();
                        if(confirmacion.equals("1")){
                            x.setSaldo(saldonuevo);
                            System.out.println("Cantidad depositada correctamente");
                        } else {
                            System.out.println("Se cancelo la operacion");
                        }
                    } else if (x==null) {
                        System.out.println("Esa tarjeta no existe");
                    }
                    break;
                case 14:
                    System.out.println("** REALIZAR RETIRO DE TARJETA DE DEBITO  **");
                    System.out.println("Ingresa el No de tarjeta a depositar");
                    String NoTarjetaRetiro=scanner.nextLine().trim();
                    Debito tarjetaRetiro=banco.validarTarjeta(NoTarjetaRetiro);
                    if (tarjetaRetiro != null) {
                        System.out.println("Tarjeta encontrada: " + tarjetaRetiro.getNumeroTarjeta());
                        Cliente persona=tarjetaRetiro.getTitular();
                        String name=persona.getNombre();
                        System.out.println("El titular es: " + name);
                        System.out.println("Ingresa la catidad a retirar");
                        double dinero= scanner.nextDouble();
                        double saldoAnterior = tarjetaRetiro.getSaldo();
                        double saldonuevo=saldoAnterior-dinero;
                        tarjetaRetiro.setSaldo(saldonuevo);
                        System.out.println("Cantidad retirada correctamente ");
                        banco.guardarOperación(name,NoTarjetaRetiro,saldoAnterior, saldonuevo, LocalDateTime.now(),"Retiro");
                    } else if (tarjetaRetiro==null) {
                        System.out.println("Esa tarjeta no existe ");
                    }
                    break;
                case 15:
                    break;
                case 16:
                    break;
                case 17:
                    break;
                case 18:
                    banco.mostrarDebitos();
                    break;
                case 19:
                    System.out.println("\nAdios-");
                    break;
            }
        } catch (Exception e) {
            System.err.println("Ocurrió un error durante la operación: " + e.getMessage());
        }
    }
}
