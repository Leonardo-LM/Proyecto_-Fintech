package menus;

import operaciones_Bancarias.Banco;
import usuarios.Usuario;

import java.util.Scanner;


public class Login {
    private final Scanner scanner = new Scanner(System.in);
    public MenuEjecutivo menuEjecutivo = new MenuEjecutivo();
    public MenuGerente menuGerente = new MenuGerente();
    public Banco banco = new Banco();

    public void login() {
        int intesntosMax = 5, intentosUsuario = 0;

        MenuCliente menuCliente = new MenuCliente();

        int opc;
        do {
            opc = menuGerente.mostrarMenu(banco.gerenteDefault);
            menuGerente.procesarDatosMenu(opc, banco.gerenteDefault, banco);
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

            /*if (usuarioEnSesion instanceof Usuario) {

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
        }*/
            System.out.println("Intentos maximos permitidos ");
        }

    /*private int mostrarErrorInicioSesion(int intentosUsuario) {
        System.out.println("Usuario o contraseña incorrectos, intenta de nuevo");
        return intentosUsuario + 1;
    }*/
    }
}
