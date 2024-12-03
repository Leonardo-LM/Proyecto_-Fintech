import archivos.Archivos;
import menus.Login;
import usuarios.gerentes.Gerente;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
      //Login login = new Login();
        //login.login();

        Gerente gerente = new Gerente("a","b", "c", "d","e","f","g","h", 14.5);
        List<Gerente>ListaGerentes = new ArrayList<>();
        ListaGerentes.add(gerente);
        Archivos.guardarGerentes(ListaGerentes);
        List<Gerente> listagerentes2 = Archivos.informacionGerentes();
        for (Gerente g : listagerentes2) {
            System.out.println(g);
        }

    }

}