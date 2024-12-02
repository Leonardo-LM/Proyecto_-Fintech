package usuarios.ejecutivos;

import usuarios.Usuario;
import utils.Rol;

public class Ejecutivo extends Usuario {

    public Ejecutivo(String id, String nombre, String apellidoPaterno, String apellidoMaterno, String RFC, String CURP, String email) {
        super(id,nombre, apellidoPaterno, apellidoMaterno, RFC, CURP, email, Rol.EJECUTIVO);
    }

    public String mostrarDatos() {
        String datosCliente = String.format(" Email: %s", email);
        return super.mostrarInformacion() + datosCliente;
    }
}
