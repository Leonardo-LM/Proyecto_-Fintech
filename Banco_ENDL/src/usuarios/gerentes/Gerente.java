package usuarios.gerentes;

import usuarios.empleados.Empleado;
import utils.Rol;

import java.io.Serializable;

public class Gerente extends Empleado implements Serializable {

    public Gerente(String id, String nombre, String apellidoPaterno, String apellidoMaterno, String RFC, String CURP, String email, String sucursal, double salario) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, RFC, CURP, email, sucursal, salario, Rol.GERENTE);
    }
    public Gerente() {
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "sucursal='" + sucursal + '\'' +
                ", id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", RFC='" + RFC + '\'' +
                ", email='" + email + '\'' +
                ", rol=" + rol +
                '}';
    }
}
//// java bean /Constructor vacío, to String , getters y setters