package usuarios.clientes;

import tarjetas.Debito;
import usuarios.Usuario;
import utils.Rol;

import java.time.LocalDate;

public class Cliente extends Usuario {
    public LocalDate fechaRegistro;
    public String sucursal;
    public double saldo;
    public Debito tarjetaDebito;

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, String RFC, String CURP, String email, LocalDate fechaRegistro, double saldo, String sucursal, Debito tarjetaDebito) {
        super(nombre, apellidoPaterno, apellidoMaterno, RFC, CURP, email, Rol.CLIENTE);
        this.fechaRegistro = fechaRegistro;
        this.saldo = saldo;
        this.sucursal = sucursal;
        this.tarjetaDebito = tarjetaDebito;
    }

    public String mostrarDatos() {
        String datosCliente = String.format("");
        return super.mostrarInformacion() + datosCliente;
    }

    //-------------------------SETTER & GETTER-----------------------------------

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public Debito getTarjetaDebito() {
        return tarjetaDebito;
    }

    public void setTarjetaDebito(Debito tarjetaDebito) {
        this.tarjetaDebito = tarjetaDebito;
    }
}
