package usuarios;

import utils.Rol;

import java.io.Serializable;
// poner implements en todas las clases para transformar objetos a binario
// clase con métodos para manejar
public class Ejecutivo extends Empleado implements Serializable {
    public Ejecutivo(String nombre, String apellido, String RFC, String CURP, String email, String sucursal, double salario, Rol rol) {
        super(nombre, apellido, RFC, CURP, email, sucursal, salario, rol);
    }


}
