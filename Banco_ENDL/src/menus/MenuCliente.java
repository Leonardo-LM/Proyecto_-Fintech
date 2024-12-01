package menus;


import operaciones_Bancarias.Banco;
import usuarios.clientes.Cliente;

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
                        1.- Hacer deposito
                        2.- Hacer retiro
                        3.- Saldo de cuenta
                        4.- Solicitar tarjeta de credito
                        5.- Hacer compra
                        6.- Salir""");
            System.out.print("Elija una opción: ");
            //respuesta = scanner.nextInt();

            try {
                respuesta = Integer.parseInt(sc.nextLine());
                if (respuesta < 1 || (respuesta > 8 && respuesta != 6)) {
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
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                System.out.println("\nAdios-");
                break;
        }
    }
}

