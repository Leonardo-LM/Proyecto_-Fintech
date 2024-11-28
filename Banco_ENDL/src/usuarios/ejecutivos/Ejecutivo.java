package usuarios.ejecutivos;

import usuarios.Usuario;
import utils.Rol;

public class Ejecutivo extends Usuario {

    public Ejecutivo(String nombre, String apellidoPaterno, String apellidoMaterno, String RFC, String CURP, String email, Rol rol) {
        super(nombre, apellidoPaterno, apellidoMaterno, RFC, CURP, email, rol);
    }
}
