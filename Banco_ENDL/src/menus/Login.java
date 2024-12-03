package menus;

import operaciones_Bancarias.Banco;
import usuarios.Usuario;
import usuarios.clientes.Cliente;
import usuarios.ejecutivos.Ejecutivo;
import usuarios.gerentes.Gerente;
import utils.Rol;

import java.util.Scanner;


public class Login {
    private Scanner scanner = new Scanner(System.in);
    public MenuEjecutivo menuEjecutivo = new MenuEjecutivo();
    public MenuGerente menuGerente = new MenuGerente();
    public MenuCliente menuCliente = new MenuCliente();
     Banco banco = new Banco();
    public Usuario usuarioEnSesion;

    public void login() {
        int intentosMaximos = 5, intentosUser=0;
        int opc;
        do {
            opc =menuGerente.mostrarMenu(banco.gerenteDefault,banco);
        }while (opc != 19);
        while(intentosUser < intentosMaximos){
            System.out.print("\n--------Bienvenido/a--------\n");
            System.out.println("---Inicia sesión para continuar---");
            System.out.print("Ingrese su id de usuario: ");
            String idUser = scanner.nextLine();
            //System.out.println(idUser);
            System.out.print("Ingrese su curp: ");
            String curp = scanner.nextLine();
            //System.out.println(curp);
            usuarioEnSesion = banco.validarInicioSesion(idUser,curp.toUpperCase());
            //System.out.println(usuarioEnSesion);
            if (usuarioEnSesion instanceof Usuario){
                if (usuarioEnSesion.getRol() == Rol.CLIENTE){
                    Cliente clienteEnSesion = (Cliente) usuarioEnSesion;
                    int opcion = menuCliente.mostrarDatos(clienteEnSesion,banco);
                    intentosUser=0;
                }else if (usuarioEnSesion.getRol() == Rol.EJECUTIVO){
                    Ejecutivo ejecutivoEnSesion = (Ejecutivo) usuarioEnSesion;
                    int opcion = menuEjecutivo.mostrarMenu(ejecutivoEnSesion,banco);
                    intentosUser=0;
                }else{
                    Gerente gerenteEnSesion = (Gerente) usuarioEnSesion;
                    opc = menuGerente.mostrarMenu(banco.gerenteDefault,banco);
                    intentosUser=0;
                }
            }else{
                intentosUser= mostrarErrorInicioSesion(intentosUser);
            }
        }
        System.out.println("\nLímite de intentos alcanzado\n");
    }

    private int mostrarErrorInicioSesion(int intentosUser){
        System.out.print("\nId de usuaio o contraseña que es la CURP incorrecta, intente de nuevo\n");
        intentosUser++;
        return intentosUser;
    }

}
