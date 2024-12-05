package usuarios.clientes;

import tarjetas.Credito;
import tarjetas.Debito;
import usuarios.Usuario;
import utils.Rol;

import java.io.Serializable;
import java.time.LocalDate;

public class Cliente extends Usuario implements Serializable {
    public LocalDate fechaRegistro;
    public String sucursal;
    public Debito tarjetaDebito;
    public Credito tarjetaCredito;
    public int controlador=0;

    public Cliente(String id, String nombre, String apellidoPaterno, String apellidoMaterno, String RFC, String CURP, String email, LocalDate fechaRegistro, String sucursal) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, RFC, CURP, email, Rol.CLIENTE);
        this.fechaRegistro = fechaRegistro;
        this.sucursal = sucursal;
        this.tarjetaDebito = tarjetaDebito;
        this.tarjetaCredito= tarjetaCredito;
    }

    public Cliente(String id, String nombre, String apellidoPaterno, String apellidoMaterno, String RFC, String CURP, String email, LocalDate fechaRegistro, String sucursal, Debito tarjetaDebito, Credito tarjetaCredito) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, RFC, CURP, email, Rol.CLIENTE);
        this.fechaRegistro = fechaRegistro;
        this.sucursal = sucursal;
        this.tarjetaDebito = tarjetaDebito;
        this.tarjetaCredito= tarjetaCredito;
    }

    public Cliente (){}


    public String mostrarDatos() {
        if(tarjetaCredito!=null){
            String datosCliente = String.format(", Tarjeta Debito No: %s, Tarjeta Credito No: %s,", tarjetaDebito.getNumeroTarjeta(), tarjetaCredito.getNumeroTarjeta());
            return super.mostrarInformacion() + datosCliente;
        } else {
           String numeroTarjetaCredito="no tiene aun";
            String datosCliente = String.format(", Tarjeta Debito No: %s, Tarjeta Credito No: %s",tarjetaDebito.getNumeroTarjeta(),numeroTarjetaCredito);
            return super.mostrarInformacion() + datosCliente;
        }
    }

    //-------------------------SETTER & GETTER-----------------------------------

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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

    public Credito getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(Credito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public void setControlador(int controlador) {
        this.controlador = controlador;
    }

    /*@Override
    public String toString() {
        return "Cliente{" +
                "fechaRegistro=" + fechaRegistro +
                ", sucursal='" + sucursal + '\'' +
                ", tarjetaDebito=" + tarjetaDebito +
                ", tarjetaCredito=" + tarjetaCredito +
                ", controlador=" + controlador +
                ", id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", RFC='" + RFC + '\'' +
                ", email='" + email + '\'' +
                ", rol=" + rol +
                '}';
    }*/

    @Override
    public String toString() {
        return "Cliente{" +
                "fechaRegistro=" + fechaRegistro +
                ", sucursal='" + sucursal + '\'' +
                ", tarjetaDebito=" + (tarjetaDebito != null ? tarjetaDebito : "N/A") +
                ", tarjetaCredito=" + (tarjetaCredito != null ? tarjetaCredito.getNumeroTarjeta() : "N/A") +
                ", controlador=" + controlador +
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
