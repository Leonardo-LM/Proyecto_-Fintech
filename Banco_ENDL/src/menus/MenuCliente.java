package menus;


import usuarios.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCliente {
    public operaciones_Bancarias.Banco banco = new operaciones_Bancarias.Banco();
    public ArrayList<Cliente> listaClientes = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    public int mostrarDatos() {
        for (Cliente cliente : listaClientes) {
            if (cliente.getTarjetaDebito().getSaldo() < 30000) {
                System.out.println("""
                        \n***BIENVENIDO***
                        1.- Hacer deposito
                        2.- Hacer retiro
                        3.- Saldo de cuenta
                        4.- Salir""");
                int opcion = sc.nextInt();
                return opcion;
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
        return 0;

    }

    public void procesarDatos(int opcion) {

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
                banco.mostrarSaldoCliente();
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }
}

