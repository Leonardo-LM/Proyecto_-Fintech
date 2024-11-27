package operaciones_Bancarias;

import usuarios.Gerente;
import usuarios.Usuario;

import java.time.LocalDate;

import menus.Login;
import menus.MenuCliente;
import menus.MenuEjecutivo;
import menus.MenuGerente;


import java.util.ArrayList;

public class Banco {
    public Gerente gerenteDefault;
    public MenuCliente menuCliente = new MenuCliente();
    public MenuEjecutivo menuEjecutivo = new MenuEjecutivo();
    public MenuGerente menuGerente = new MenuGerente();
    public Login login = new Login();


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

    //-------------------------VALLIDACIONES-----------------------------

}
