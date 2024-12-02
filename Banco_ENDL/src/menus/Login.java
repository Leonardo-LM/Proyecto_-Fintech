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
            usuarioEnSesion = banco.validarInicioSesion(idUser,curp);
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


   /* private final Scanner scanner = new Scanner(System.in);
    public MenuEjecutivo menuEjecutivo = new MenuEjecutivo();
    public MenuGerente menuGerente = new MenuGerente();
    public Banco banco = new Banco();

    public void login() {
        int intesntosMax = 5, intentosUsuario = 0;

        int opc;
        do {
            opc = menuGerente.mostrarMenu(banco.gerenteDefault);
            menuGerente.procesarDatosMenu(opc, banco);
        } while (opc != 13);


        while (intentosUsuario < intesntosMax) {
            System.out.print("\n--------Bienvenido/a--------\n");
            System.out.println("---Inicia sesión para continuar---");

            scanner.nextLine();
            System.out.println("Ingresa tu usuario: ");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa tu contaseña : ");
            String contasena = scanner.nextLine();
            Usuario usuarioEnSesion = banco.validarInicioSesion(usuario, contasena);

            if (usuarioEnSesion instanceof Usuario) {

                if (usuarioEnSesion.getRol() == Rol.CLIENTE) {
                    Cliente clienteEnSesion = (Cliente) usuarioEnSesion;
                    menuCliente.MenuCliente(clienteEnSesion);
                    intentosUsuario = 0;
                } else if (usuarioEnSesion.getRol() == Rol.EMPLEADO) {
                    Empleado empleadoEnSesion = (Empleado) usuarioEnSesion;
                } else {
                    Gerente adminEnSesion = (Administrador) usuarioEnSesion;
                    this.mostrarMenuAdmin(adminEnSesion);
                    intentosUsuario = 0;
                }
            } else {
                intentosUsuario = mostrarErrorInicioSesion(intentosUsuario);

            }
        }
            System.out.println("Intentos maximos permitidos ");
        }

    private int mostrarErrorInicioSesion(int intentosUsuario) {
        System.out.println("Usuario o contraseña incorrectos, intenta de nuevo");
        return intentosUsuario + 1;
    }
    }*/
}
