package menus;

import operaciones_Bancarias.Banco;
import tarjetas.Debito;
import usuarios.clientes.Cliente;
import usuarios.ejecutivos.Ejecutivo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
// implementar interfaz serializable
public class MenuEjecutivo {
    Scanner scanner = new Scanner(System.in);
    boolean band = false;
    public int mostrarMenu(Ejecutivo ejecutivo,Banco banco) {
        int respuesta = 0;
        while (respuesta != 11) {
            System.out.println("\nBienvenido " + ejecutivo.nombre);
            System.out.println("""
                    \n---------- MENU DEL EJECUTIVO ----------
                    Gestión de clientes >
                        1.- Registrar un cliente  
                        2.- Consultar lista de clientes 
                        3.- Buscar cliente por  Id
                        4.- Actualizar datos de cliente
                        5.- Eliminar un cliente   
                    Operaciones bancarias >
                        6.- Deposito de tarjeta de débito  
                        7.- Retiro de tarjeta de débito 
                        9.- Retiro tarjeta de credito
                        10.- Pagar tarjeta de credito
                    11.- Salir""");
            System.out.print("Elija una opción: ");
            try {
                respuesta = Integer.parseInt(scanner.nextLine());
                if (respuesta < 1 || respuesta > 11) {
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
        try {
            String nombre, apellidoP, apellidoM, RFC, CURP, email, sucursal = "Banco";
            LocalDate fechaRegistro = LocalDate.now();
        switch (opcion) {
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
                );

                banco.registrarCliente(cliente);
                banco.generarTarjetaDebito(cliente);
                break;
            case 2:
                System.out.println("** Consultar lista de clientes **");
                banco.mostrarClientes();
                break;
            case 3:
                System.out.println("Buscar cliente por ID.");
                String idClienteBusqueda = scanner.next();
                banco.mostrarClientePorId(idClienteBusqueda);

                break;
            case 4:
                System.out.println("** ACTUALIZAR DATOS DE UN CLIENTE **");
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
                System.out.println("** DEPOSITO A TARJETA DE DEBITO **");
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
                    double saldoAnterior = x.getSaldo();
                    double saldonuevo=saldoAnterior+dinero;
                    System.out.println("Ingresa 1 Acreditar la operacion de lo contario se cancelara");
                    scanner.nextLine();
                    String confirmacion=scanner.nextLine();
                    if(confirmacion.equals("1")){
                        x.setSaldo(saldonuevo);
                        System.out.println("Cantidad depositada correctamente");
                        banco.guardarOperación(name,NoTarjeta,saldoAnterior, saldonuevo, LocalDateTime.now(),"Deposito a tarjeta de debito");
                    } else {
                        System.out.println("Se cancelo la operacion");
                    }
                } else if (x==null) {
                    System.out.println("Esa tarjeta no existe");
                }
                break;
            case 7:
                System.out.println("** REALIZAR RETIRO DE TARJETA DE DEBITO  **");
                System.out.println("Ingresa el No de tarjeta a retirar");
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
                    banco.guardarOperación(name,NoTarjetaRetiro,saldoAnterior, saldonuevo, LocalDateTime.now(),"Retiro de tarjeta de debito");
                } else if (tarjetaRetiro==null) {
                    System.out.println("Esa tarjeta no existe ");
                }
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                System.out.println("adios");
                break;
            default:
                System.out.println("No es opcion valida");
        }
        } catch (Exception e) {
            System.err.println("Ocurrió un error durante la operación: " + e.getMessage());
        }

    }
}
