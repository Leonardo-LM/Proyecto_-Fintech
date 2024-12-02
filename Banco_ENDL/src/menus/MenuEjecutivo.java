package menus;

import operaciones_Bancarias.Banco;
import tarjetas.Debito;
import transacciones.Transaccion;
import usuarios.clientes.Cliente;
import usuarios.ejecutivos.Ejecutivo;

import java.awt.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
<<<<<<< HEAD
// implementar interfaz serializable
public class MenuEjecutivo implements Serializable {
=======

public class MenuEjecutivo {
>>>>>>> 6e0daa3e1d5be8d989f58ea8d2675f93da32bee3
    Scanner scanner = new Scanner(System.in);
    boolean band = false;

    public int mostrarMenu(Ejecutivo ejecutivo,Banco banco) {
        int respuesta = 0;
        while (respuesta != 8) {
            System.out.println("\nBienvenido " + ejecutivo.nombre);
            System.out.println("""
                    \n---------- MENU DEL EJECUTIVO ----------
<<<<<<< HEAD
                    1.-  Registrar un cliente **YA
                    2.-  Eliminar un cliente **YA
                    3.-  Mostrar lista de clientes **YA 
                    4.-  Buscar cliente por ID **YA
                    5.-  Actualizar datos de cliente **YA
                    6.-  Consultar historial de movimientos
                    7.-  Realizar deposito tarjeta debito **YA
                    8.-  Realizar retiro /// debito y credito
                    9.-  Pagar tarjeta de credito /// 8 y 9 solo para clientes 
                    8.- Salir""");
=======
                    ||Diego A.
                        Gestión de clientes >
                            1.- Registrar un cliente
                            2.- Consultar lista de clientes
                            3.- Buscar cliente por nombre o número de cuenta.
                            4.- Actualizar datos de cliente
                            5.- Dar de baja a un cliente
                    ||Diego A. 
                     Operaciones bancarias >
                        6.- Deposito de tarjeta de débito --Nico Avocado
                        7.- Retiro de tarjeta de débito --Estrella
                        8.- Compra tarjeta débito/credito --Diego A. (debito)
                        9.- Retiro tarjeta de credito
                        10.- Pagar tarjeta de credito
                    11.- Salir""");
>>>>>>> 6e0daa3e1d5be8d989f58ea8d2675f93da32bee3
            System.out.print("Elija una opción: ");
            respuesta = scanner.nextInt();

            try {
                respuesta = Integer.parseInt(scanner.nextLine());
<<<<<<< HEAD
                if (respuesta < 1 || (respuesta > 7 && respuesta != 8)) {
=======
                if (respuesta < 1 || (respuesta > 10 && respuesta != 11)) {
>>>>>>> 6e0daa3e1d5be8d989f58ea8d2675f93da32bee3
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
        String sucursal = "Matriz";
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
                String CURP = scanner.nextLine().trim();
                System.out.print("Email: ");
                String email = scanner.nextLine().trim();
                //Tarjetas
                double saldo = 10000;

                Cliente cliente = new Cliente(banco.generarIdCliente(),nombre, apellidoP, apellidoM, RFC, CURP, email, LocalDate.now(),saldo,"Matriz");
                banco.registrarCliente(cliente);
                banco.generarTarjetaDebito(cliente);


                break;

            case 2:
                System.out.println(" ** ELIMINAR A UN CLIENTE ** ");
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

            case 3:
                System.out.println("** LISTA DE CLIENTES REGISTRADOS **");
                banco.mostrarClientes();
                break;

            case 4:
                System.out.println("** DATOS DE UN CLIENTE **");
                System.out.println("Ingrese el ID del cliente a consultar ");
                String IdCliente = scanner.nextLine();
                banco.obtenerInformacionCliente(IdCliente);
                break;

            case 5:
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

            case 6:
                System.out.println("** HISTORIAL DE TRANSACCIONES **");
                System.out.println("Ingrese la tarjeta/cuanta que desea consultar: ");
                String tarjeta = scanner.nextLine();
                banco.obtenerTransaccionesPorTitular(tarjeta);
                break;

            case 7:
                System.out.println("** REALIZAR DEPOSITO A TARJETA DE DEBITO **");
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
                    x.setSaldo(saldonuevo);
                    System.out.println("Cantidad depositada correctamente ");
                    banco.guardarOperación(name,NoTarjeta,saldoAnterior, saldonuevo, LocalDateTime.now(),"Deposito");

                } else if (x==null) {
                    System.out.println("Esa tarjeta no existe ");
                }
                break;
            case 8:
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

            default:
                System.out.println("No es opcion valida");
        }

    }
}
