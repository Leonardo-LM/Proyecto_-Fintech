package operaciones_Bancarias;

import tarjetas.Credito;
import tarjetas.Debito;
import usuarios.Cliente;
import usuarios.Ejecutivo;
import usuarios.Gerente;
import usuarios.Usuario;

import java.time.LocalDate;

import menus.Login;
import menus.MenuCliente;
import menus.MenuEjecutivo;
import menus.MenuGerente;


import java.util.ArrayList;
import java.util.Random;

public class Banco {
    public ArrayList<Cliente> listaClientes = new ArrayList<>();
    public ArrayList<Gerente> listaGerentes = new ArrayList<>();
    public ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public ArrayList<Ejecutivo> listaEjecutivos = new ArrayList<>();
    public ArrayList<Debito> listaDebitos = new ArrayList<>();
    public ArrayList<Credito> listaCreditos = new ArrayList<>();
    public Gerente gerenteDefault;
    public MenuCliente menuCliente = new MenuCliente();
    public MenuEjecutivo menuEjecutivo = new MenuEjecutivo();
    public MenuGerente menuGerente = new MenuGerente();
    public Login login = new Login();
    public Random rand = new Random();


    public Banco() {
        //this.gerenteDefault = new Gerente();
    }

    //Metodos
    public String generarRFC(String nombre, String apellido, LocalDate fechaRegistro) {
        char letraIApellPaterno = apellido.charAt(0);
        boolean vocal = false;
        int i = 0;
        String cadena = "";
        while (i < apellido.length() & !vocal) {
            if ((apellido.charAt(i) == 'a') ||
                    (apellido.charAt(i) == 'e') ||
                    (apellido.charAt(i) == 'i') ||
                    (apellido.charAt(i) == 'o') ||
                    (apellido.charAt(i) == 'u')) {

                cadena += apellido.charAt(i);
                vocal = true;

            }
            i++;
        }
        return "adadad";
    }

    //-----------------------------------------------------METODOS CRUD---------------------------------------------------

    //----------------------------------CREATE---------------------------------------------

    public void registrarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void registrarGerente(Gerente gerente) {
        listaGerentes.add(gerente);
    }

    public void registrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public void registrarEjecutivo(Ejecutivo ejecutivo) {
        listaEjecutivos.add(ejecutivo);
    }

    public void registrarDebito(Debito debito) {
        listaDebitos.add(debito);
    }

    public void registrarCredito(Credito credito) {
        listaCreditos.add(credito);
    }


    //----------------------------------UPDATE---------------------------------------------


    //----------------------------------DELETE---------------------------------------------

    //-------------------------VALLIDACIONES-----------------------------

    //-------------------------GENERADORES-----------------------------

    public Debito generarTarjetaDebito() {
        int digitos1 = rand.nextInt(9);
        int digitos2 = rand.nextInt(9);
        int digitos3 = rand.nextInt(9);
        int digitos4 = rand.nextInt(9);
        int digitos5 = rand.nextInt(9);

        String tarjetadebito = String.format("%04d 04%d 04%d 04%d", digitos1, digitos2, digitos3, digitos4);
        LocalDate fechaCreacion = LocalDate.now();
        double saldo = 10000;
        String cvv = "";
        for (int i = 0; i < 3; i++) {
            cvv += rand.nextInt(9);
        }
        String clabeInter = String.format("%04d %04d %04d %04d %02d", digitos1, digitos2, digitos3, digitos4, digitos5);
        LocalDate fechaVencimineto = fechaCreacion.plusYears(5);

        return
    }

    public String generarIdCliente() {
// C -{año actual} - {mes actual} - {longitud usuarios.pacientes +1} - {1,100000}
        LocalDate fecha = LocalDate.now();

        int anoActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        //int longitudClientesMasUno =  this.listaConsultas.size() + 1;
        int longitudClientesMasUno = this.listaClientes.size() + 1;
        int numeroAleatorio = rand.nextInt(1, 100000);

        return String.format("C-%d-%d-%d-%d", anoActual, mesActual, longitudClientesMasUno, numeroAleatorio);
    }

    //-----------------------MOSTRAR DATOS------------------------

    public void mostrarSaldoCliente(String id) {
        for (Cliente cliente : listaClientes) {

        }

    }

}
