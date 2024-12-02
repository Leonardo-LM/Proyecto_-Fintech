package menus;


import operaciones_Bancarias.Banco;
<<<<<<< HEAD
import tarjetas.Debito;
import transacciones.Transaccion;
=======
>>>>>>> 6e0daa3e1d5be8d989f58ea8d2675f93da32bee3
import usuarios.clientes.Cliente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuCliente {
    public ArrayList<Cliente> listaClientes = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    public int mostrarDatos(Cliente cliente, Banco banco) {
        /*for (Cliente cliente : listaClientes) {
            if (cliente.getTarjetaDebito().getSaldo() < 30000) {
                System.out.println("""
                        \n***BIENVENIDO***
                        1.- Hacer deposito
                        2.- Hacer retiro
                        3.- Saldo de cuenta
                        4.- Salir""");
                int opcion = sc.nextInt();
                return opcion;                         ///FALTA HACER ESO DE LA TARJETA EN EL DE ABAJO LO HICE ASI PARRA QUE FUNCIONARA
            } else {
                System.out.println("""
                        1.- Hacer deposito
                        2.- Hacer retiro
                        3.- Saldo de cuenta
                        5.- Solicitar tarjeta de credito
                        6.- Hacer compra
                        4.- Salir""");
                int opcion = sc.nextInt();
                return opcion;
            }
        }
        return 0;*/
        int respuesta = 0;
        while (respuesta != 6) {
            System.out.println("\nBienvenido " + cliente.nombre);
            System.out.println("""
                        1.- Hacer deposito --Nico
                        2.- Hacer retiro --Estrella
                        3.- Saldo de cuenta
                        4.- Solicitar tarjeta de credito, retiro o como pagar en caso de tener tarjeta --
                        5.- Hacer compra --Diego A.(Debito)
                        6.- Ver mi información --Diego A.
                        7.- Ver mi historial de movimientos --Estrella 
                        8.- Salir""");
            System.out.print("Elija una opción: ");

            try {
                respuesta = Integer.parseInt(sc.nextLine());
                if (respuesta < 1 || (respuesta > 7 && respuesta != 8)) {
                    System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero y válido somso.");
            }
<<<<<<< HEAD
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
=======
            procesarDatos(respuesta,banco);
>>>>>>> 6e0daa3e1d5be8d989f58ea8d2675f93da32bee3
        }

        return respuesta;
    }

    public void procesarDatos(int opcion,Banco banco) {

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
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
<<<<<<< HEAD
                System.out.println("** HISTORIAL DE TRANSACCIONES **");
                System.out.println("Ingrese la tarjeta/cuanta que desea consultar: ");
                String tarjetaA = sc.nextLine();
                banco.obtenerTransaccionesPorTitular(tarjetaA);
                break;
            case 7:
=======
>>>>>>> 6e0daa3e1d5be8d989f58ea8d2675f93da32bee3
                System.out.println("\nAdios-");
                break;
        }
    }
}

