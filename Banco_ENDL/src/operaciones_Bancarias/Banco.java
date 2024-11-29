package operaciones_Bancarias;

import tarjetas.Credito;
import tarjetas.Debito;
import usuarios.clientes.Cliente;
import usuarios.ejecutivos.Ejecutivo;
import usuarios.gerentes.Gerente;
import usuarios.Usuario;
import java.time.LocalDate;
import menus.Login;
import menus.MenuCliente;
import menus.MenuEjecutivo;
import menus.MenuGerente;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Banco {
    public Gerente gerenteDefault;
    public ArrayList<Cliente> listaClientes = new ArrayList<>();
    public ArrayList<Gerente> listaGerentes = new ArrayList<>();
    public ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public ArrayList<Ejecutivo> listaEjecutivos = new ArrayList<>();
    public ArrayList<Debito> listaDebitos = new ArrayList<>();
    public ArrayList<Credito> listaCreditos = new ArrayList<>();
    public MenuCliente menuCliente = new MenuCliente();
    public MenuEjecutivo menuEjecutivo = new MenuEjecutivo();
    public MenuGerente menuGerente = new MenuGerente();
    public Login login = new Login();
    public Random rand = new Random();
    public Scanner scanner = new Scanner(System.in);


    public Banco() {
        //this.gerenteDefault = new Gerente();
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

    //Verificar que se actualicen los datos en los archivos binarios

    public void actualizarDatosCliente(Cliente cliente) {
        try {
            System.out.println("¿Desea cambiar nombre? s/n");
            System.out.print("Selección: ");
            if (scanner.nextLine().equalsIgnoreCase("s")) {
                System.out.println("Nombre actual: " + cliente.getNombre());
                System.out.print("Nombre nuevo: ");
                String nuevoNombre = scanner.nextLine().trim();
                if (nuevoNombre.isEmpty()) throw new IllegalArgumentException("El nombre no puede estar vacío.");
                cliente.setNombre(nuevoNombre);
            }

            System.out.println("¿Desea actualizar el apellido paterno o materno? s/n");
            if (scanner.nextLine().equalsIgnoreCase("s")) {
                System.out.println("¿Desea actualizar el apellido paterno? s/n");
                if (scanner.nextLine().equalsIgnoreCase("s")) {
                    System.out.println("Apellido paterno actual: " + cliente.getApellidoPaterno());
                    System.out.print("Apellido paterno nuevo: ");
                    String nuevoApellidoP = scanner.nextLine().trim();
                    if (nuevoApellidoP.isEmpty()) throw new IllegalArgumentException("El apellido paterno no puede estar vacío.");
                    cliente.setApellidoPaterno(nuevoApellidoP);
                } else {
                    System.out.println("Apellido materno actual: " + cliente.getApellidoMaterno());
                    System.out.print("Apellido materno nuevo: ");
                    String nuevoApellidoM = scanner.nextLine().trim();
                    if (nuevoApellidoM.isEmpty()) throw new IllegalArgumentException("El apellido materno no puede estar vacío.");
                    cliente.setApellidoMaterno(nuevoApellidoM);
                }
            }

            System.out.println("¿Desea actualizar su CURP? s/n");
            if (scanner.nextLine().equalsIgnoreCase("s")) {
                System.out.println("CURP actual: " + cliente.getCURP());
                System.out.print("CURP nuevo: ");
                String nuevoCURP = scanner.nextLine().trim();
                if (nuevoCURP.isEmpty()) throw new IllegalArgumentException("El CURP no puede estar vacío.");
                cliente.setCURP(nuevoCURP);
            }

            System.out.println("¿Desea actualizar su email? s/n");
            if (scanner.nextLine().equalsIgnoreCase("s")) {
                System.out.println("Email actual: " + cliente.getEmail());
                System.out.print("Email nuevo: ");
                String nuevoEmail = scanner.nextLine().trim();
                if (nuevoEmail.isEmpty()) throw new IllegalArgumentException("El email no puede estar vacío.");
                cliente.setEmail(nuevoEmail);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    public void actualizarDatosEjecutivo(Ejecutivo ejecutivo) {
        try {
            System.out.println("¿Desea cambiar el nombre? (s/n)");
            System.out.print("Selección: ");
            if (scanner.nextLine().trim().equalsIgnoreCase("s")) {
                System.out.println("Nombre actual: " + ejecutivo.getNombre());
                System.out.print("Nombre nuevo: ");
                String nuevoNombre = scanner.nextLine().trim();
                if (nuevoNombre.isEmpty()) {
                    throw new IllegalArgumentException("El nombre no puede estar vacío.");
                }
                ejecutivo.setNombre(nuevoNombre);
            }

            System.out.println("¿Desea actualizar el apellido paterno o materno? (s/n)");
            System.out.print("Selección: ");
            if (scanner.nextLine().trim().equalsIgnoreCase("s")) {
                System.out.println("¿Desea actualizar el apellido paterno? (s/n)");
                System.out.print("Selección: ");
                if (scanner.nextLine().trim().equalsIgnoreCase("s")) {
                    System.out.println("Apellido paterno actual: " + ejecutivo.getApellidoPaterno());
                    System.out.print("Apellido paterno nuevo: ");
                    String nuevoApellidoPaterno = scanner.nextLine().trim();
                    if (nuevoApellidoPaterno.isEmpty()) {
                        throw new IllegalArgumentException("El apellido paterno no puede estar vacío.");
                    }
                    ejecutivo.setApellidoPaterno(nuevoApellidoPaterno);
                } else {
                    System.out.println("Apellido materno actual: " + ejecutivo.getApellidoMaterno());
                    System.out.print("Apellido materno nuevo: ");
                    String nuevoApellidoMaterno = scanner.nextLine().trim();
                    if (nuevoApellidoMaterno.isEmpty()) {
                        throw new IllegalArgumentException("El apellido materno no puede estar vacío.");
                    }
                    ejecutivo.setApellidoMaterno(nuevoApellidoMaterno);
                }
            }

            System.out.println("¿Desea actualizar su CURP? (s/n)");
            System.out.print("Selección: ");
            if (scanner.nextLine().trim().equalsIgnoreCase("s")) {
                System.out.println("CURP actual: " + ejecutivo.getCURP());
                System.out.print("CURP nuevo: ");
                String nuevoCURP = scanner.nextLine().trim();
                if (nuevoCURP.isEmpty()) {
                    throw new IllegalArgumentException("El CURP no puede estar vacío.");
                }
                ejecutivo.setCURP(nuevoCURP);
            }

            System.out.println("¿Desea actualizar su email? (s/n)");
            System.out.print("Selección: ");
            if (scanner.nextLine().trim().equalsIgnoreCase("s")) {
                System.out.println("Email actual: " + ejecutivo.getEmail());
                System.out.print("Email nuevo: ");
                String nuevoEmail = scanner.nextLine().trim();
                if (nuevoEmail.isEmpty()) {
                    throw new IllegalArgumentException("El email no puede estar vacío.");
                }
                ejecutivo.setEmail(nuevoEmail);
            }

            System.out.println("Actualización completada con éxito.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }


    //----------------------------------DELETE---------------------------------------------

    //Verificar que se eliminen en los archivos binarios

    public void darBajaCliente(String idCliente) {
        try {
            Cliente cliente = this.listaClientes.stream()
                    .filter(c -> c.getId().equals(idCliente))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Cliente con ID " + idCliente + " no encontrado."));
            this.listaClientes.remove(cliente);
            System.out.println("Cliente eliminado correctamente.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void darBajaEjecutivo(String idEjecutivo) {
        try {
            Ejecutivo ejecutivo = this.listaEjecutivos.stream()
                    .filter(e -> e.getId().equals(idEjecutivo))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Ejecutivo con ID " + idEjecutivo + " no encontrado."));
            this.listaEjecutivos.remove(ejecutivo);
            System.out.println("Ejecutivo eliminado correctamente.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    //---------------------------------Busquedas------------------------------------------
    public Cliente obtenerClientePorId(String idCliente){
        return this.listaClientes.stream().filter(
                cliente -> cliente.getId().equals(idCliente)
        ).findFirst().orElse(null);
    }

    public Ejecutivo obtenerEjecutivoPorId(String idEjecutivo){
        return this.listaEjecutivos.stream().filter(
                ejecutivo -> ejecutivo.getId().equals(idEjecutivo)
        ).findFirst().orElse(null);
    }

    //-------------------------VALLIDACIONES-----------------------------

    //-------------------------GENERADORES-----------------------------

    public Debito generarTarjetaDebito(Cliente titular) {
        int digitos1 = rand.nextInt(9);
        int digitos2 = rand.nextInt(9);
        int digitos3 = rand.nextInt(9);
        int digitos4 = rand.nextInt(9);
        int digitos5 = rand.nextInt(9);

        String numeroDebito = String.format("%04d 04%d 04%d 04%d", digitos1, digitos2, digitos3, digitos4);
        LocalDate fechaCreacion = LocalDate.now();
        double saldo = 10000;
        String cvv = "";
        for (int i = 0; i < 3; i++) {
            cvv += rand.nextInt(9);
        }
        String clabeInter = String.format("%04d %04d %04d %04d %02d", digitos1, digitos2, digitos3, digitos4, digitos5);
        LocalDate fechaVencimineto = fechaCreacion.plusYears(5);

        Debito tarjetadebito = new Debito(titular, numeroDebito, fechaCreacion, saldo, cvv, clabeInter, fechaVencimineto);


        return tarjetadebito;
    }

    public String generarIdCliente() {
// C -{año actual} - {mes actual} - {longitud usuarios.pacientes +1} - {1,100000}
        LocalDate fecha = LocalDate.now();

        int anoActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int longitudClientesMasUno = this.listaClientes.size() + 1;
        int numeroAleatorio = rand.nextInt(1, 100000);

        return String.format("C-%d-%d-%d-%d", anoActual, mesActual, longitudClientesMasUno, numeroAleatorio);
    }

    public String generarIdEjecutivo() {
// E -{año actual} - {mes actual} - {longitud usuarios.pacientes +1} - {1,100000}
        LocalDate fecha = LocalDate.now();

        int anoActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int longitudClientesMasUno = this.listaClientes.size() + 1;
        int numeroAleatorio = rand.nextInt(1, 100000);

        return String.format("E-%d-%d-%d-%d", anoActual, mesActual, longitudClientesMasUno, numeroAleatorio);
    }

    public String generarRFC(String nombre, String apellidoP, String apellidoM , LocalDate fechaRegistro) {
        String primerasLetrasApellidoPaterno = apellidoP.charAt(0) + apellidoP.charAt(1) +"";
        String primerLetraApellidoMaterno = apellidoM.charAt(0) +"";
        String letraInicialNombre = nombre.charAt(0) + "";
        String anio = fechaRegistro.getYear() + "";
        String ultimosDosDigitosAño = anio.charAt(2) + anio.charAt(3) + "";
        String mes = fechaRegistro.getMonth() + "";
        String dia = fechaRegistro.getMonth() + "";

        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String homoclave = "";

        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            homoclave += caracteres.charAt(random.nextInt(caracteres.length()));
        }

        homoclave +=  random.nextInt(9);;

        return String.format("%s,%s, %s, %s, %s,%s,%s", primerasLetrasApellidoPaterno,primerLetraApellidoMaterno, letraInicialNombre, ultimosDosDigitosAño, mes, dia, homoclave);
    }

    //-----------------------MOSTRAR DATOS------------------------

    public void mostrarSaldoCliente(String id) {
        for (Cliente cliente : listaClientes) {

        }

    }

    public void mostrarClientes() {
        System.out.println("\n*** CLIENTES DEL BANCO ***");
        if (listaClientes.isEmpty()) {
            System.out.println("No hay clientes registrados aún");
        }else {
            for (Cliente cliente : this.listaClientes) {
                System.out.println(cliente.mostrarDatos());
            }
        }
    }
    public void mostrarEjecutivos() {
        System.out.println("\n*** EJECUTIVOS DEL BANCO ***");
        if (listaEjecutivos.isEmpty()) {
            System.out.println("No hay ejecutivos registrados aún");
        }else {
            for (Ejecutivo ejecutivo : this.listaEjecutivos) {
                System.out.println(ejecutivo.mostrarDatos());
            }
        }
    }

}
