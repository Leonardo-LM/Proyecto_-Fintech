package operaciones_Bancarias;

import archivos.Archivos;
import tarjetas.Credito;
import tarjetas.Debito;
import tarjetas.SolicitudTarjetaCredito;
import transacciones.Transaccion;
import usuarios.clientes.Cliente;
import usuarios.ejecutivos.Ejecutivo;
import usuarios.empleados.Empleado;
import usuarios.gerentes.Gerente;
import usuarios.Usuario;
import java.time.LocalDate;
import menus.MenuCliente;
import menus.MenuEjecutivo;
import menus.MenuGerente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Banco {
    public Gerente gerenteDefault = new Gerente("1","Gerente", "1", "1","1","1","1","Banco",23);
    public ArrayList<Cliente> listaClientes = new ArrayList<>();
    public ArrayList<Gerente> listaGerentes = new ArrayList<>();
    public ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public ArrayList<Ejecutivo> listaEjecutivos = new ArrayList<>();
    public ArrayList<Debito> listaDebitos = new ArrayList<>();
    public ArrayList<Transaccion> listaTransacciones = new ArrayList<>();
    public ArrayList<Credito> listaCreditos = new ArrayList<>();
    public ArrayList<SolicitudTarjetaCredito>listaSolicitudes=new ArrayList<>();
    // public MenuCliente menuCliente = new MenuCliente();
    //public MenuEjecutivo menuEjecutivo = new MenuEjecutivo();
    //public MenuGerente menuGerente = new MenuGerente();
    public Random rand = new Random();
    public Scanner scanner = new Scanner(System.in);

<<<<<<< HEAD

=======
>>>>>>> a961e0a0fade68ac5de91b2115cb000f67734acc
    public Banco() {
        //this.gerenteDefault = new Gerente();
        gerenteDefault=new Gerente("123","Conrado","De León","Lopez","PDL","123","hola@gmail.com","Banco",200000.00);
        this.listaGerentes.add(gerenteDefault);
        this.listaUsuarios.add(gerenteDefault);
    }


    //-----------------------------------------------------METODOS CRUD---------------------------------------------------

    //----------------------------------CREATE---------------------------------------------

    public void registrarCliente(Cliente cliente) {
        listaClientes.add(cliente);
        System.out.println("Cliente registrado exitosamente.");
        registrarUsuario(cliente);
        Archivos.guardarCliente(cliente);
    }

    public void registrarGerente(Gerente gerente) {
        listaGerentes.add(gerente);
        registrarUsuario(gerente);
    }

    public void registrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        System.out.println("Usuario añadido.");
    }

    public void registrarEjecutivo(Ejecutivo ejecutivo) {
        listaEjecutivos.add(ejecutivo);
        System.out.println("Ejecutivo registrado exitosamente.");
        registrarUsuario(ejecutivo);
    }

    public void registrarDebito(Debito debito) {
        listaDebitos.add(debito);
    }

    public void registrarCredito(Credito credito) {
        listaCreditos.add(credito);
    }

    public void registrarSolicitud(SolicitudTarjetaCredito solicitud) {
        listaSolicitudes.add(solicitud);
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
            Archivos.guardarClientes(this.listaClientes); /// se guarda en archivos la nueva lista sin el cliente
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
            Archivos.guardarEjecutivos(this.listaEjecutivos);
            System.out.println("Ejecutivo eliminado correctamente.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    //---------------------------------Busquedas------------------------------------------

    public Cliente obtenerClientePorId(String idCliente){
        return this.listaClientes.stream().filter(
                cliente -> cliente.getId().equals(idCliente)
        ).findFirst().orElse(null); }


    public Ejecutivo obtenerEjecutivoPorId(String idEjecutivo){
        return this.listaEjecutivos.stream().filter(
                ejecutivo -> ejecutivo.getId().equals(idEjecutivo)
        ).findFirst().orElse(null); }

    //-------------------------VALLIDACIONES-----------------------------

    //-------------------------GENERADORES-----------------------------

    public Debito generarTarjetaDebito(Cliente titular) {
        String numeroDebito = String.format(
                "%04d %04d %04d %04d",
                rand.nextInt(9000) + 1000,
                rand.nextInt(9000) + 1000,
                rand.nextInt(9000) + 1000,
                rand.nextInt(9000) + 1000
        );

        String cvv = String.format("%03d", rand.nextInt(1000));
        String clabeInter = String.format(
                "%04d %04d %04d %04d %02d",
                rand.nextInt(9000) + 1000,
                rand.nextInt(9000) + 1000,
                rand.nextInt(9000) + 1000,
                rand.nextInt(9000) + 1000,
                rand.nextInt(90) + 10
        );

        LocalDate fechaCreacion = LocalDate.now();
        LocalDate fechaVencimiento = fechaCreacion.plusYears(5);
        double saldo = 10000;

<<<<<<< HEAD
        Debito tarjetadebito = new Debito(titular, numeroDebito, fechaCreacion, saldo, cvv, clabeInter, fechaVencimineto);
        registrarDebito(tarjetadebito);
        Archivos.guardarTarjetaDebito(tarjetadebito);
        titular.setTarjetaDebito(tarjetadebito);///ASOCIAMOS TRAJETA DEBITO
        return tarjetadebito;
=======
        Debito tarjetaDebito = new Debito(
                titular,
                numeroDebito,
                fechaCreacion,
                saldo,
                cvv,
                clabeInter,
                fechaVencimiento
        );

        registrarDebito(tarjetaDebito);
        titular.setTarjetaDebito(tarjetaDebito);

        return tarjetaDebito;
>>>>>>> a961e0a0fade68ac5de91b2115cb000f67734acc
    }


    ///AÑADI *-*-
    public Credito generarTarjetaCredito(Cliente titular) {
        String numeroCredito = String.format(
                "%04d %04d %04d %04d",
                rand.nextInt(9000) + 1000,
                rand.nextInt(9000) + 1000,
                rand.nextInt(9000) + 1000,
                rand.nextInt(9000) + 1000
        );

        String cvv = String.format("%03d", rand.nextInt(1000));
        String clabeInter = String.format(
                "%04d %04d %04d %04d %02d",
                rand.nextInt(9000) + 1000,
                rand.nextInt(9000) + 1000,
                rand.nextInt(9000) + 1000,
                rand.nextInt(9000) + 1000,
                rand.nextInt(90) + 10
        );
        LocalDate fechaCreacion = LocalDate.now();
        LocalDate fechaVencimiento = fechaCreacion.plusYears(5);
        double saldolimite = 100000;

        Credito tarjetaCredito = new Credito(
                titular,
                numeroCredito,
                fechaCreacion,
                saldolimite,
                cvv,
                clabeInter,
                fechaVencimiento
        );
        registrarCredito(tarjetaCredito);
<<<<<<< HEAD
        Archivos.guardarTarjetaCredito(tarjetaCredito);
        titular.setTarjetaCredito(tarjetaCredito);///ASOCIAMOS TRAJETA CREDITO
=======
        titular.setTarjetaCredito(tarjetaCredito);

>>>>>>> a961e0a0fade68ac5de91b2115cb000f67734acc
        return tarjetaCredito;
    }

    /// AÑADI *-*-

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

    public String generarRFC(String nombre, String apellidoP, String apellidoM, LocalDate fechaRegistro) {
        apellidoP = apellidoP.toUpperCase();
        char primeraLetraApellidoP = apellidoP.charAt(0);
        char primeraVocalApellidoP = 'X';
        for (int i = 1; i < apellidoP.length(); i++) {
            char c = apellidoP.charAt(i);
            if ("AEIOU".indexOf(c) >= 0) {
                primeraVocalApellidoP = c;
                break;
            }
        }

        apellidoM = apellidoM.toUpperCase();
        char primerLetraApellidoM = apellidoM.isEmpty() ? 'X' : apellidoM.charAt(0);

        nombre = nombre.toUpperCase();
        char letraInicialNombre = nombre.charAt(0);

        String ultimosDosDigitosAnio = String.format("%02d", fechaRegistro.getYear() % 100);

        String mes = String.format("%02d", fechaRegistro.getMonthValue());
        String dia = String.format("%02d", fechaRegistro.getDayOfMonth());

        Random random = new Random();
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder homoclave = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            homoclave.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        homoclave.append(random.nextInt(10)); //Este método añade el nnumero random a la homoclave es un concatenador

        return String.format("%c%c%c%c%s%s%s%s",
                primeraLetraApellidoP, primeraVocalApellidoP, primerLetraApellidoM, letraInicialNombre,
                ultimosDosDigitosAnio, mes, dia, homoclave);
    }

    //-----------------------MOSTRAR DATOS------------------------

    public void mostrarDetallesTarjeta(Cliente cliente) {
        System.out.println("\n---------- DETALLES DE LA TARJETA ----------");

        System.out.println("Bienvenid@ " + cliente.getNombre());
        if (cliente.getTarjetaDebito() != null) {
            System.out.println("Número de Tarjeta Débito: " + cliente.getTarjetaDebito().getNumeroTarjeta());
            System.out.println("CVV de Débito: " + cliente.getTarjetaDebito().getCvv());
            System.out.println("Saldo: $" + cliente.getTarjetaDebito().getSaldo());
            System.out.println("Fecha de vencimiento de tarjeta: " + cliente.getTarjetaDebito().getFechaVencimiento());
        } else {
            System.out.println("No tiene tarjeta de débito.");
        }

        if (cliente.getTarjetaCredito() != null) {
            System.out.println("Número de Tarjeta Crédito: " + cliente.getTarjetaCredito().getNumeroTarjeta());
            System.out.println("CVV de Crédito: " + cliente.getTarjetaCredito().getCvv());
            System.out.println("Saldo: $" + cliente.getTarjetaCredito().getSaldo());
            System.out.println("Fecha de Vencimiento de tarjeta: " + cliente.getTarjetaCredito().getFechaVencimiento());
        } else {
            System.out.println("No tiene tarjeta de crédito.");
        }

        System.out.println("Sucursal: " + cliente.getSucursal());
        System.out.println("Fecha de Registro: " + cliente.getFechaRegistro());
        System.out.println("--------------------------------------------");
    }


    public void mostrarClientePorId(String id){
        Cliente cliente = obtenerClientePorId(id);
        if (cliente != null) {
            System.out.println(cliente.mostrarDatos());
        } else {
            System.out.println("No se encontró el cliente con el ID " + id);
        }
    }

    public void mostrarEjecutivoPorId(String id){
        Ejecutivo ejecutivo = obtenerEjecutivoPorId(id);
        if (ejecutivo != null) {
            System.out.println(ejecutivo.mostrarDatos());
        } else {
            System.out.println("No se encontró el cliente con el ID " + id);
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

    public Usuario validarInicioSesion(String idUser, String curp){
        for (Usuario usuario : listaUsuarios) {
            //System.out.println("Revisando ID: " + usuario.getId());
            if (usuario.getId().equals(idUser) && usuario.getCURP().equals(curp)) {
                return usuario;
            }
        }
        return null;
    }

    public void mostrarUsuarios() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("\n*** LISTA DE USUARIOS ***");
            for (Usuario usuario : listaUsuarios) {
                System.out.println(usuario.mostrarInformacion());
            }
        }
    }
    public void mostrarDebitos() {
        System.out.println("\n*** CLIENTES DEL BANCO ***");
        if (listaDebitos.isEmpty()) {
            System.out.println("No hay clientes registrados aún");
        }else {
            for (Debito debito: this.listaDebitos) {
                System.out.println(debito.mostrarDatos());
            }
        }
    }

    public Debito validarTarjeta(String NoTarjeta){
        for (Debito debito : listaDebitos) {
            System.out.println("Revisando NO: " + debito.getNumeroTarjeta());
            if (debito.getNumeroTarjeta().equals(NoTarjeta)) {
                return debito;
            }
        }
        return null;
    }

    public String SolicitudTCredito (Cliente cliente){
        String IdCliente=cliente.getId();
        String Nombre=cliente.getNombre();
        Debito tarjetaCliente=cliente.getTarjetaDebito();
        double saldo=tarjetaCliente.getSaldo();
        Boolean Autorizacion=false;
        SolicitudTarjetaCredito solicitud = new SolicitudTarjetaCredito(IdCliente,Nombre,Autorizacion,saldo);
        registrarSolicitud(solicitud);
        return "Se ha mandado la solicitud a nuestro Gerente Correctamente";
    }

    public void mostrarSolitudes() {
            if (listaSolicitudes.isEmpty()) {
            System.out.println("No hay solicitudes de tarjeta de credito\n");
            } else {
            System.out.println("\n*** LISTA DE SOLICITUDES ***\n");
            for (SolicitudTarjetaCredito solicitudTarjetaCredito : listaSolicitudes) {
                System.out.println(solicitudTarjetaCredito.mostrarDatos());
            }
            }
    }

    public void autorizarTarjetaCredito(){
        int opcion =0;
        while (opcion!=2){
            System.out.print("Desea autorizar alguna T.Credito\n");
            System.out.print("1.-Si\n");
            System.out.print("2.-No\n");
            System.out.println("Selecciona una opcion: ");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el id del cliente que desea autorizar su T.Credito");
                    scanner.nextLine();
                    String id= scanner.nextLine();
                    validarSolicitud(id);
                    break;
                case 2:
                    System.out.println("vale!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
            }
        }
    }

    public void validarSolicitud(String id){
        for (SolicitudTarjetaCredito solicitudTarjetaCredito:listaSolicitudes) {
            if (solicitudTarjetaCredito.getIdClienteSolicitador().equals(id)) {
                solicitudTarjetaCredito.setTarjetaAutorizada(true);
                System.out.println("Tarjeta de Credito aprobada exitosamente ");
                Cliente cliente =BuscarCliente(id);
                generarTarjetaCredito(cliente);
            } else {
                System.out.println("Ese cliente no ha mandado solicitud");
            }
        }
    }

    public Cliente BuscarCliente(String id){
        for (Cliente cliente : listaClientes) {;
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public String obtenerInformacionCliente(String idCliente) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId().equals(idCliente)) {
                // Formatear la información del cliente como un String
                return String.format(
                        "ID: %s\nNombre: %s %s %s\nRFC: %s\nCURP: %s\nEmail: %s\nFecha de Registro: %s\nSucursal: %s\n Tarjeta Debito %s" ,
                        cliente.getId(),
                        cliente.getNombre(),
                        cliente.getApellidoPaterno(),
                        cliente.getApellidoMaterno(),
                        cliente.getRFC(),
                        cliente.getCURP(),
                        cliente.getEmail(),
                        cliente.getFechaRegistro().toString(),
                        cliente.getSucursal(),
                        cliente.getTarjetaDebito()
                );
            }
        }
        return "Cliente no encontrado.";
    }
    public void guardarOperación (String nombreUsuario,String NoTarjeta,double saldoAnterior,double  saldonuevo, LocalDateTime fecha, String operacion ){
        Transaccion transaccion = new Transaccion(nombreUsuario,NoTarjeta,saldoAnterior, saldonuevo, LocalDateTime.now(),operacion);
        listaTransacciones.add(transaccion);}

    public List<String> obtenerTransaccionesPorTitular(String tarjeta) {
        AtomicInteger contador = new AtomicInteger(1);
        return this.listaTransacciones.stream().filter(transaccion -> transaccion.getNumeroTarjeta().equals(tarjeta))
                .map(transaccion -> String.format(
                        "Número de transacción: %d\nTitular: %s\nTarjeta asociada: %s\nFecha: %s\nDescripción: %s\n",
                        contador.getAndIncrement(),
                        transaccion.getTitular(),
                        transaccion.getNumeroTarjeta(),
                        transaccion.getMomentoDeOperacion().toString(),
                        transaccion.getOperación()
                )).collect(Collectors.toList());
    }

}

