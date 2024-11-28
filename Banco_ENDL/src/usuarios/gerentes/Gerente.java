package usuarios;


import javax.management.relation.Role;

public class Gerente extends Empleado {

    public Gerente(String nombre, String apellido, String RFC, String CURP, String email, String sucursal, double salario, Role rol) {
        super(nombre, apellido, RFC, CURP, email, sucursal, salario, rol);
    }
}
