package menus;


import usuarios.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCliente {
    public operaciones_Bancarias.Banco banco = new operaciones_Bancarias.Banco();
    public ArrayList<Cliente> clientes = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void mostrarMenuCliente() {
        for (Cliente cliente : clientes) {
            if (cliente.getSaldo() < 30000) {
                int opcion = 6;

                while (opcion != 4) {
                    System.out.println("""
                            1.- Hacer deposito
                            2.- Hacer retiro
                            3.- Saldo de cuenta
                            4.- Salir""");
                    opcion = sc.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.print("Digite el numero de la tarjeta:");
                            double numeroTarjeta = sc.nextDouble();

                            System.out.print("Digite la cantidad a depositar: ");
                            double deposito = sc.nextDouble();

                            break;
                        case 2:
                            System.out.print("Digite la cantidad a retirar: ");
                            double retiro = sc.nextDouble();
                            break;
                        case 3:
                            System.out.println("***** SALDO DE LA CUENTA *****");
                            break;
                        case 4:
                            break;
                    }
                }
            } else {
                System.out.println("""
                        1.- Hacer deposito
                        2.- Hacer retiro
                        3.- Saldo de cuenta
                        5.- Solicitar tarjeta de debito
                        6.- Hacer compra
                        4.- Salir""");
            }
        }
    }
}
