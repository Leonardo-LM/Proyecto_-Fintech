package archivos;

import tarjetas.Credito;
import tarjetas.Debito;
import tarjetas.SolicitudTarjetaCredito;
import transacciones.Transaccion;
import usuarios.Usuario;
import usuarios.clientes.Cliente;
import usuarios.ejecutivos.Ejecutivo;
import usuarios.gerentes.Gerente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Archivos {
    // metodos estaticos
    public static final String clientes = "clientes.dat"; // ruta donde se crea el archivo
    public static final String gerentes = "gerentes.dat";
    public static final String usuarios = "usuarios.dat";
    public static final String ejecutivos = "ejecutivos.dat";
    public static final String tarjetasDebito = "tarjetasDebito.dat";
    public static final String tarjetasCredito = "tarjetasCredito.dat";
    public static final String transacciones = "transacciones.dat";
    public static final String creditos = "solicitudesCreditos.dat";


    ////////////////////////////////  CLIENTES  ////////////////////////////////////
    public static void guardarClientes(List<Cliente> listaClientes) {
        try {
            FileOutputStream archivo = new FileOutputStream(clientes); // accede al archivo y si  e =xiste lo crea
            ObjectOutputStream escritorDelArchivo = new ObjectOutputStream(archivo);
            escritorDelArchivo.writeObject(listaClientes); // guarda la lista en el archivo
            escritorDelArchivo.close(); // para cerrar siempre
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo" + e.getMessage());
        }
    }

    public static List<Cliente> informacionClientes() { // retorna la lista para trabajar con ella
        List<Cliente> listaClientes = new ArrayList();
        try {
            FileInputStream archivo = new FileInputStream(clientes);
            ObjectInputStream lectorDelArchivo = new ObjectInputStream(archivo);
            listaClientes = (List<Cliente>) lectorDelArchivo.readObject();
            lectorDelArchivo.close();

        } catch (IOException e) {
            System.out.println("Error al abrir el archivo" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al encontrar el archivo" + e.getMessage());
        }
        return listaClientes;
    }


    /////////////////////////// GERENTES //////////////////////////////////////////////////
    public static void guardarGerentes(List<Gerente> listaGerentes) {
        try {
            FileOutputStream archivo = new FileOutputStream(gerentes); // accede al archivo y si no existe lo crea
            ObjectOutputStream escritorDelArchivo = new ObjectOutputStream(archivo);
            escritorDelArchivo.writeObject(listaGerentes); // guarda la lista en el archivo
            escritorDelArchivo.close(); // para cerrar siempre
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<Gerente> informacionGerentes() { // retorna la lista para trabajar con ella
        List<Gerente> listaGerentes = new ArrayList();
        try {
            FileInputStream archivo = new FileInputStream(gerentes);
            ObjectInputStream lectorDelArchivo = new ObjectInputStream(archivo);
            listaGerentes = (List<Gerente>) lectorDelArchivo.readObject();
            lectorDelArchivo.close();

        } catch (IOException e) {
            System.out.println("Error al abrir el archivo" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al encontrar el archivo" + e.getMessage());
        }
        return listaGerentes;
    }

    public static void eliminarGerente(String idGerente) { ///// no se está usando
        List<Gerente> listaGerentes = Archivos.informacionGerentes();
        listaGerentes.removeIf(gerente -> gerente.getId().equals(idGerente));
        Archivos.guardarGerentes(listaGerentes);
    }

    /////////////////////////////// TRANSACCIONES ////////////////////////////
    public static void guardarTransacciones(List<Transaccion> listaTransacciones) {
        try {
            FileOutputStream archivo = new FileOutputStream(transacciones); // accede al archivo y si no existe lo crea
            ObjectOutputStream escritorDelArchivo = new ObjectOutputStream(archivo);
            escritorDelArchivo.writeObject(listaTransacciones); // guarda la lista en el archivo
            escritorDelArchivo.close(); // para cerrar siempre
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo" + e.getMessage());
        }
    }

    public static List<Transaccion> informacionTransacciones() { // retorna la lista para trabajar con ella
        List<Transaccion> listaT = new ArrayList();
        try {
            FileInputStream archivo = new FileInputStream(clientes);
            ObjectInputStream lectorDelArchivo = new ObjectInputStream(archivo);
            listaT = (List<Transaccion>) lectorDelArchivo.readObject();
            lectorDelArchivo.close();

        } catch (IOException e) {
            System.out.println("Error al abrir el archivo" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al encontrar archivo" + e.getMessage());
        }
        return listaT;
    }

    /////////////////////////////// SOLICITUDES ////////////////////////////
    public static void guardarSolicitudes(List<SolicitudTarjetaCredito> listaSolicitudes) {
        try {
            FileOutputStream archivo = new FileOutputStream(creditos); // accede al archivo y si no existe lo crea
            ObjectOutputStream escritorDelArchivo = new ObjectOutputStream(archivo);
            escritorDelArchivo.writeObject(listaSolicitudes); // guarda la lista en el archivo
            escritorDelArchivo.close(); // para cerrar siempre
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo" + e.getMessage());
        }
    }

    public static List<SolicitudTarjetaCredito> informacionSolicitudes() { // retorna la lista para trabajar con ella
        List<SolicitudTarjetaCredito> listaT = new ArrayList();
        try {
            FileInputStream archivo = new FileInputStream(creditos);
            ObjectInputStream lectorDelArchivo = new ObjectInputStream(archivo);
            listaT = (List<SolicitudTarjetaCredito>) lectorDelArchivo.readObject();
            lectorDelArchivo.close();

        } catch (IOException e) {
            System.out.println("Error al abrir el archivo" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al encontrar archivo" + e.getMessage());
        }
        return listaT;
    }

    ////////////////////////////////////////////// USUARIOS //////////////////////////////////////777
    public static void guardarUsuarios(List<Usuario> listaUsuarios) {
        for (Usuario usuario : listaUsuarios) {
            System.out.println(usuario.toString());
        }
        try {
            FileOutputStream archivo = new FileOutputStream(usuarios); // accede al archivo y si no existe lo crea
            ObjectOutputStream escritorDelArchivo = new ObjectOutputStream(archivo);
            escritorDelArchivo.writeObject(listaUsuarios); // guarda la lista en el archivo
            escritorDelArchivo.close();
            System.out.println("blablabla");// para cerrar siempre
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<Usuario> informacionUsuarios() { // retorna la lista para trabajar con ella
        List<Usuario> listaUsuarios = new ArrayList();
        try {
            FileInputStream archivo = new FileInputStream(usuarios);
            ObjectInputStream lectorDelArchivo = new ObjectInputStream(archivo);
            listaUsuarios = (List<Usuario>) lectorDelArchivo.readObject();
            lectorDelArchivo.close();

        } catch (IOException e) {
            System.out.println("Error al abrir el archivo" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al encontrar el archivo" + e.getMessage());
        }
        return listaUsuarios;
    }

    /////////////////////// EJECUTIVOS /////////////////////////////////////////////7

    public static void guardarEjecutivos(List<Ejecutivo> listaEjecutivos) {
        try {
            FileOutputStream archivo = new FileOutputStream(ejecutivos); // accede al archivo y si no existe lo crea
            ObjectOutputStream escritorDelArchivo = new ObjectOutputStream(archivo);
            escritorDelArchivo.writeObject(listaEjecutivos); // guarda la lista en el archivo
            escritorDelArchivo.close(); // para cerrar siempre
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<Ejecutivo> informacionEjecutivos() { // retorna la lista para trabajar con ella
        List<Ejecutivo> listaEjetivos = new ArrayList();
        try {
            FileInputStream archivo = new FileInputStream(ejecutivos);
            ObjectInputStream lectorDelArchivo = new ObjectInputStream(archivo);
            listaEjetivos = (List<Ejecutivo>) lectorDelArchivo.readObject();
            lectorDelArchivo.close();

        } catch (IOException e) {
            System.out.println("Error al abrir el archivo" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al encontrar el archivo" + e.getMessage());
        }
        return listaEjetivos;
    }


    /////////////////////////// TARJETAS DEBITO /////////////////////////////////7
    public static void guardarTarjetasDebito(List<Debito> listaDebito) {
        System.out.println("Guardar");
        try {
            FileOutputStream archivo = new FileOutputStream(tarjetasDebito); // accede al archivo y si no existe lo crea
            ObjectOutputStream escritorDelArchivo = new ObjectOutputStream(archivo);
            escritorDelArchivo.writeObject(listaDebito); // guarda la lista en el archivo
            escritorDelArchivo.close(); // para cerrar siempre
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<Debito> informacionTarjetasDebito() { // retorna la lista para trabajar con ella
        List<Debito> listaDebito = new ArrayList();
        try {
            FileInputStream archivo = new FileInputStream(tarjetasDebito);
            ObjectInputStream lectorDelArchivo = new ObjectInputStream(archivo);
            listaDebito = (List<Debito>) lectorDelArchivo.readObject();
            lectorDelArchivo.close();

        } catch (IOException e) {
            System.out.println("Error al abrir el archivo" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al encontrar el archivo" + e.getMessage());
        }
        return listaDebito;
    }


    ////////////////////////////// CREDITO //////////////////////////////
    public static void guardarTarjetasCredito(List<Credito> listaCredito) {
        try {
            FileOutputStream archivo = new FileOutputStream(tarjetasCredito); // accede al archivo y si no existe lo crea
            ObjectOutputStream escritorDelArchivo = new ObjectOutputStream(archivo);
            escritorDelArchivo.writeObject(listaCredito); // guarda la lista en el archivo
            escritorDelArchivo.close(); // para cerrar siempre
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<Credito> informacionTarjetasCredito() { // retorna la lista para trabajar con ella
        List<Credito> listaCredito = new ArrayList();
        try {
            FileInputStream archivo = new FileInputStream(tarjetasCredito);
            ObjectInputStream lectorDelArchivo = new ObjectInputStream(archivo);
            listaCredito = (List<Credito>) lectorDelArchivo.readObject();
            lectorDelArchivo.close();

        } catch (IOException e) {
            System.out.println("Error al abrir el archivo" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al encontrar el archivo" + e.getMessage());
        }
        return listaCredito;
    }


    //////////////// PARA GUARDAR UN NUEVO USUARIO ////////////////// /// agrega solo uno

    public static void guardarCliente(Cliente cliente) {
        List<Cliente> listaClientes = informacionClientes();
        listaClientes.add(cliente);
        guardarClientes(listaClientes);
    }

    public static void guardarGerente(Gerente gerente) {
        List<Gerente> listaGerentes = informacionGerentes();
        listaGerentes.add(gerente);
        guardarGerentes(listaGerentes);
    }

    public static void guardarEjecutivo(Ejecutivo ejecutivo) { /// agrega solo uno
        List<Ejecutivo> listaEjecutivos = informacionEjecutivos();
        listaEjecutivos.add(ejecutivo);
        guardarEjecutivos(listaEjecutivos);
    }

    public static void guardarTransaccione(Transaccion transaccion) {
        List<Transaccion> listaTransacciones = informacionTransacciones();
        listaTransacciones.add(transaccion);
        guardarTransacciones(listaTransacciones);
    }

    public static void guardarUsuario(Usuario usuario) {
        List<Usuario> listaUsuarios = informacionUsuarios();
        listaUsuarios.add(usuario);
        guardarUsuarios(listaUsuarios);
    }

    public static void guardarTarjetaDebito(Debito debito) {
        List<Debito> listaDebito = informacionTarjetasDebito();
        listaDebito.add(debito);
        guardarTarjetasDebito(listaDebito);
    }

    public static void guardarTarjetaCredito(Credito credito) {
        List<Credito> listaCredito = informacionTarjetasCredito();
        listaCredito.add(credito);
        guardarTarjetasCredito(listaCredito);
    }



}
