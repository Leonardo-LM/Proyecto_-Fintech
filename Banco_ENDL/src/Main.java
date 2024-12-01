import menus.MenuCliente;
import menus.MenuEjecutivo;
import menus.MenuGerente;
import operaciones_Bancarias.Banco;


public class Main {
    public static void main(String[] args) {


        Banco banco = new Banco();
        MenuGerente menuGerente = new MenuGerente();
        menuGerente.mostrarMenu(banco.gerenteDefault);
        //menuCliente.mostrarDatos();
//        ArrayList<Cliente> clientes = new ArrayList<>();
//        Cliente cliente1 = new Cliente("a", "a", "d", "d", "d", LocalDate.now(), "a" );

        //Archivos.guardarClientes(clientes);

//        List<Cliente> listaClientes2 =Archivos.informacioClientes(); // esto te guarda en un objeto
//        for (Cliente cliente : listaClientes2) {
//            /// se trabaja lo q sea de la lista
//        }

    }

    // lista de transacciones con un objeto centralizado
}