package usuarios.ejecutivos;

import usuarios.Usuario;
import utils.Rol;

import java.io.Serializable;

public class Ejecutivo extends Usuario implements Serializable {

    public Ejecutivo(String id, String nombre, String apellidoPaterno, String apellidoMaterno, String RFC, String CURP, String email) {
        super(id,nombre, apellidoPaterno, apellidoMaterno, RFC, CURP, email, Rol.EJECUTIVO);
    }
    public Ejecutivo() {}

    public String mostrarDatos() {
        String datosCliente = String.format(" Email: %s", email);
        return super.mostrarInformacion() + datosCliente;
    }

    @Override
    public String toString() {
        return "Ejecutivo{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", RFC='" + RFC + '\'' +
                ", email='" + email + '\'' +
                ", rol=" + rol +
                '}';
    }
}
