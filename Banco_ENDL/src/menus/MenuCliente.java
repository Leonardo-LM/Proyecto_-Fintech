package menus;


import operaciones_Bancarias.Banco;
import tarjetas.Debito;
import transacciones.Transaccion;
import usuarios.clientes.Cliente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuCliente {
    private int controlador = 0;
    public ArrayList<Cliente> listaClientes = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    public int mostrarDatos(Cliente cliente, Banco banco) {

        int respuesta = 0;
        while (respuesta != 6) {
            if (cliente.getTarjetaDebito().getSaldo() < 30000) {
                Double saldo = cliente.getTarjetaDebito().getSaldo();
                Double falta=30000.0-saldo;
            System.out.println("\nBienvenido " + cliente.nombre);
            System.out.println("""
                        1.- Hacer deposito
                        2.- Hacer retiro
                        3.- Saldo de cuenta
                        4.-Te faltan %.2f pesos para poder solicitar una tarjeta de credito
                        5.- Hacer compra
                        6.-Ver mis datos
                        6.- Salir""".formatted(falta));
            System.out.print("Elija una opción: ");

            try {
                respuesta = Integer.parseInt(sc.nextLine());
                if (respuesta < 1 || (respuesta > 8 && respuesta != 6)) {
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
                        6.- Consultar mis transacciones 
                        7.- Salir""");
                System.out.print("Elija una opción: ");

                try {
                    respuesta = Integer.parseInt(sc.nextLine());
                    if (respuesta < 1 || (respuesta > 8 && respuesta != 6)) {
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
        switch (opcion) {
            case 1:
                System.out.println("** REALIZAR DEPOSITO A TARJETA DE DEBITO **");
                System.out.println("Ingresa el No de tarjeta a depositar");
                String NoTarjeta=sc.nextLine().trim();
                Debito x=banco.validarTarjeta(NoTarjeta);
                if (x != null) {
                    System.out.println("Tarjeta encontrada: " + x.getNumeroTarjeta());
                    Cliente persona=x.getTitular();
                    String name=persona.getNombre();
                    System.out.println("El titular es: " + name);
                    System.out.println("Ingresa la catidad a depositar");
                    double dinero= sc.nextDouble();
                    double saldoAnterior = x.getSaldo();
                    double saldonuevo=saldoAnterior+dinero;
                    x.setSaldo(saldonuevo);
                    System.out.println("Cantidad depositada correctamente ");
                    banco.guardarOperación(name,NoTarjeta,saldoAnterior, saldonuevo, LocalDateTime.now(),"Deposito");
                } else if (x==null) {
                    System.out.println("Esa tarjeta no existe ");
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
                    double dinero= sc.nextDouble();
                    double saldoAnterior = tarjetaRetiro.getSaldo();
                    double saldonuevo=saldoAnterior-dinero;
                    tarjetaRetiro.setSaldo(saldonuevo);
                    System.out.println("Cantidad retirada correctamente ");
                    banco.guardarOperación(name,NoTarjetaRetiro,saldoAnterior, saldonuevo, LocalDateTime.now(),"Retiro");
                } else if (tarjetaRetiro==null) {
                    System.out.println("Esa tarjeta no existe ");
                }
                break;

            case 3:
                System.out.println("***** SALDO DE LA CUENTA *****");
                //banco.mostrarSaldoCliente();
                Debito tarjeta=cliente.getTarjetaDebito();
                Double saldodisponible=tarjeta.getSaldo();
                System.out.println(saldodisponible);
                break;
            case 4:
                if(cliente.getTarjetaCredito()==null && controlador==0) {
                    System.out.print("Solicitud de tarjeta de crédito\n");
                    System.out.print("Estamos procesando su petición " + cliente.nombre + "\n");
                    String respuesta = banco.SolicitudTCredito(cliente);
                    System.out.print(respuesta);
                    controlador++;
                }else if(cliente.getTarjetaCredito()==null && controlador>0) {
                    System.out.println("Ya mandaste solicitud espera respuesta");
                } else {
                    System.out.println("Ya cuentas con una tarjeta de credito.No puedes solicitar ya");
                }
                break;
            case 5:
                break;
            case 6:
                System.out.println("** HISTORIAL DE TRANSACCIONES **");
                System.out.println("Ingrese la tarjeta/cuanta que desea consultar: ");
                String tarjetaA = sc.nextLine();
                banco.obtenerTransaccionesPorTitular(tarjetaA);
                break;
            case 7:
                System.out.println("\nAdios-");
        }
    }
}

