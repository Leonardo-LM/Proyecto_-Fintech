import menus.Login;
import operaciones_Bancarias.Banco;


public class Main {
    public static void main(String[] args) {
  Login login = new Login();

        Banco banco = new Banco();
        banco.cargarClientes();
        banco.cargarEjecutivos();
        banco.cargarTDebito();
        banco.cargarTCredito();
        banco.cargarUsuarios();
        banco.cargarSolicitudesCredito();
        banco.cargarTransaccion();

        login.login(banco);

    }

}