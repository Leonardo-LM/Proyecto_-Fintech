package usuarios.empleados;

import usuarios.Usuario;
import utils.Rol;

import java.io.Serializable;

public class Empleado extends Usuario implements Serializable {
    // public String id;
    public String sucursal;
    private double salario;

    public Empleado(String id, String nombre, String apellidoPaterno, String apellidoMaterno, String RFC, String CURP, String email, String sucursal, double salario, Rol rol) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, RFC, CURP, email, rol);
        this.sucursal = sucursal;
        this.salario = salario;
    }

    public Empleado() {}

   // @Override
//    public String getId() {
//        return id;
//    }
//
//    @Override
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id='" + id + '\'' +
                ", sucursal='" + sucursal + '\'' +
                ", salario=" + salario +
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
