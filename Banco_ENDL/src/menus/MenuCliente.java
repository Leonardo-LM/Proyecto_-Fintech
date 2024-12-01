package menus;


import operaciones_Bancarias.Banco;
import tarjetas.Debito;
import usuarios.clientes.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCliente {
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
                        6.- Salir""");
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

                System.out.print("Digite la cantidad a depositar: ");
                double deposito = sc.nextDouble();

                break;
            case 2:
                System.out.print("Digite la cantidad a retirar: ");
                double retiro = sc.nextDouble();
                break;
            case 3:
                System.out.println("***** SALDO DE LA CUENTA *****");
                //banco.mostrarSaldoCliente();
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
                break;
            case 6:
                System.out.println("Mis datos:");
                break;
            case 7:
                System.out.println("\nAdios-");
        }
    }
}

