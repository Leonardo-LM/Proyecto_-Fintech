package usuarios.gerentes;

import usuarios.empleados.Empleado;
import utils.Rol;
public class Gerente extends Empleado {

    public Gerente(String id, String nombre, String apellidoPaterno, String apellidoMaterno, String RFC, String CURP, String email, String sucursal, double salario) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, RFC, CURP, email, sucursal, salario, Rol.GERENTE);
    }
}
