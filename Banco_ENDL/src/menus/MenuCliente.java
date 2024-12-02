package menus;


import operaciones_Bancarias.Banco;
import tarjetas.Debito;
import usuarios.clientes.Cliente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuCliente {
    public ArrayList<Cliente> listaClientes = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    public int mostrarDatos(Cliente cliente, Banco banco) {

        int respuesta = 0;
        while (respuesta != 10) {
            if (cliente.getTarjetaDebito().getSaldo() < 30000) {
                Double saldo = cliente.getTarjetaDebito().getSaldo();
                Double falta=30000.0-saldo;
            System.out.println("\nBienvenido " + cliente.nombre);
            System.out.println("""
                        1.- Hacer deposito T.Debito
                        2.- Hacer retiro T.Debito
                        3.- Saldo de cuenta
                        4.-Te faltan %.2f pesos para poder solicitar una tarjeta de credito
                        5.- Hacer compra
                        6.-Ver mi informacion
                        7.-Ver mi historial movimientos
                        8.-Pagar T.Credito
                        9.-Retiro T.credito
                        10.- Salir""".formatted(falta));
            System.out.print("Elija una opción: ");

            try {
                respuesta = Integer.parseInt(sc.nextLine());
                if (respuesta < 1 || (respuesta > 10 && respuesta != 10)) {
                    System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero y válido somso.");
            }
                if(respuesta!=4){
                 procesarDatos(respuesta,banco,cliente);
                }
          }  else {
                System.out.println("\nBienvenido " + cliente.nombre);
                System.out.println("""
                        1.- Hacer deposito
                        2.- Hacer retiro
                        3.- Saldo de cuenta
                        4.- Solicitar tarjeta de credito
                        5.- Hacer compra
                        6.-Ver mi informacion
                        7.-Ver mi historial movimientos
                        8.-Pagar T.Credito
                        9.-Retiro T.credito
                        10.- Salir""");
                System.out.print("Elija una opción: ");

                try {
                    respuesta = Integer.parseInt(sc.nextLine());
                    if (respuesta < 1 || (respuesta > 10 && respuesta != 10)) {
                        System.out.println("Opción no válida. Intente de nuevo.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número entero y válido somso.");
                }
                procesarDatos(respuesta,banco,cliente);

            }
        }

        return respuesta;
    }

    public void procesarDatos(int opcion,Banco banco,Cliente cliente) {
        try {

        switch (opcion) {
            case 1:
                System.out.println("** REALIZAR DEPOSITO A TARJETA DE DEBITO **");
                System.out.println("Hola "+cliente.nombre);
                Debito no=cliente.getTarjetaDebito();
                System.out.println("Se depositara a tu tarjeta de debito: "+no.getNumeroTarjeta());
                System.out.println("Ingresa la catidad a depositar");
                double dinero= sc.nextDouble();
                sc.nextLine();
                System.out.println("Ingresa tu cvv para acreditar la operacion o ponlo incorrecto para cancelar la operacion");
                String Codigo=sc.nextLine();
                if(no.getCvv().equals(Codigo)){
                    double saldonuevo=no.getSaldo()+dinero;
                    no.setSaldo(saldonuevo);
                    System.out.println("El cvv correcto se acredito la operacion");
                } else {
                    System.out.println("El cvv es incorrecto se cancelo la operacion");
                }
                break;
            case 2:
                System.out.println("** REALIZAR RETIRO DE TARJETA DE DEBITO  **");
                System.out.println("Ingresa el No de tarjeta a depositar");
                String NoTarjetaRetiro=sc.nextLine().trim();
                Debito tarjetaRetiro=banco.validarTarjeta(NoTarjetaRetiro);
                if (tarjetaRetiro != null) {
                    System.out.println("Tarjeta encontrada: " + tarjetaRetiro.getNumeroTarjeta());
                    Cliente persona=tarjetaRetiro.getTitular();
                    String name=persona.getNombre();
                    System.out.println("El titular es: " + name);
                    System.out.println("Ingresa la catidad a retirar");
                    double dinerox= sc.nextDouble();
                    double saldoAnterior = tarjetaRetiro.getSaldo();
                    double saldonuevo=saldoAnterior-dinerox;
                    tarjetaRetiro.setSaldo(saldonuevo);
                    System.out.println("Cantidad retirada correctamente ");
                    banco.guardarOperación(name,NoTarjetaRetiro,saldoAnterior, saldonuevo, LocalDateTime.now(),"Retiro");
                } else if (tarjetaRetiro==null) {
                    System.out.println("Esa tarjeta no existe ");
                }
                break;
            case 3:
                System.out.println("***** SALDO DE LA CUENTA *****");
                Debito tarjeta=cliente.getTarjetaDebito();
                Double saldodisponible=tarjeta.getSaldo();
                System.out.println(saldodisponible);
                break;
            case 4:
                if(cliente.getTarjetaCredito()==null && cliente.controlador==0) {
                    System.out.print("Solicitud de tarjeta de crédito\n");
                    System.out.print("Estamos procesando su petición " + cliente.nombre + "\n");
                    String respuesta = banco.SolicitudTCredito(cliente);
                    System.out.print(respuesta);
                    cliente.setControlador(1);
                }else if(cliente.getTarjetaCredito()==null && cliente.controlador>0) {
                    System.out.println("Ya mandaste solicitud espera respuesta");
                } else {
                    System.out.println("Ya cuentas con una tarjeta de credito.No puedes solicitar ya");
                }
                break;
            case 5:
                banco.mostrarDetallesTarjeta(cliente);
                break;
            case 6:
                System.out.println("Ver mi información");
                banco.mostrarClientePorId(cliente.getId());
                break;
            case 7:
                System.out.println("** HISTORIAL DE TRANSACCIONES **");
                System.out.println("Ingrese la tarjeta/cuanta que desea consultar: ");
                String tarjetaA = sc.nextLine();
                banco.obtenerTransaccionesPorTitular(tarjetaA);
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                System.out.println("\nAdios-");
                break;
            }
        } catch (Exception e) {
            System.err.println("Ocurrió un error durante la operación: " + e.getMessage());
        }
    }
}

