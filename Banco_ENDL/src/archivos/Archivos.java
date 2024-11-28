package archivos;

import transacciones.Transaccion;
import usuarios.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Archivos  {
    // metodos estaticos
 public static final String clientes = "clientes.dat"; // ruta donde se crea el archivo
public static final String transacciones = "transaccion.dat";

    // guardar clientes en una lista y mandar la lista al método
    public static void guardarClientes (List<Cliente> listaClientes){
       try {
           FileOutputStream archivo = new FileOutputStream(clientes); // accede al archivo y si no existe lo crea
           ObjectOutputStream escritorDelArchivo = new ObjectOutputStream(archivo);
           escritorDelArchivo.writeObject(listaClientes); // guarda la lista en el archivo
           escritorDelArchivo.close(); // para cerrar siempre
       } catch (IOException e ){
           System.out.println("Error al guardar el archivo" + e.getMessage());
       }
    }

    public static List<Cliente> informacioClientes (){ // retorna la lista para trabajar con ella
        List<Cliente> listaClientes = new ArrayList();
        try {
            FileInputStream archivo = new FileInputStream(clientes);
            ObjectInputStream lectorDelArchivo = new ObjectInputStream(archivo);
            listaClientes = (List<Cliente>) lectorDelArchivo.readObject();
            lectorDelArchivo.close();

        } catch (IOException e){
            System.out.println("Error al abrir el archivo" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al abrir el archivo" + e.getMessage());
        }
        return listaClientes;
    }

    // agregar metodos para guardar clientes
    public static void guardarCliente (Cliente cliente){
        // guardar cliente en lista de clientes
    }

    public static void guardarTransacciones (List<Transaccion> listaTransacciones){
        try {
            FileOutputStream archivo = new FileOutputStream(transacciones); // accede al archivo y si no existe lo crea
            ObjectOutputStream escritorDelArchivo = new ObjectOutputStream(archivo);
            escritorDelArchivo.writeObject(listaTransacciones); // guarda la lista en el archivo
            escritorDelArchivo.close(); // para cerrar siempre
        } catch (IOException e ){
            System.out.println("Error al guardar el archivo" + e.getMessage());
        }
    }

    public static List<Transaccion> informacionTransacciones (){ // retorna la lista para trabajar con ella
        List<Transaccion> listaT = new ArrayList();
        try {
            FileInputStream archivo = new FileInputStream(clientes);
            ObjectInputStream lectorDelArchivo = new ObjectInputStream(archivo);
            listaT = (List<Transaccion>) lectorDelArchivo.readObject();
            lectorDelArchivo.close();

        } catch (IOException e){
            System.out.println("Error al abrir el archivo" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al abrir el archivo" + e.getMessage());
        }
        return listaT;
    }


// para acceder se serializa la lista, despues se lee la lista y se itera en ella
}
