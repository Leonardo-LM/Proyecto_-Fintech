package usuarios.empleados;

import usuarios.Usuario;
import utils.Rol;

public class Empleado extends Usuario {
    public String sucursal;
    private double salario;

    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno, String RFC, String CURP, String email, String sucursal, double salario, Rol rol) {
        super(nombre, apellidoPaterno, apellidoMaterno, RFC, CURP, email, rol);
        this.sucursal = sucursal;
        this.salario = salario;
    }
}
