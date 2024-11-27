package usuarios;

import utils.Rol;

import java.time.LocalDate;
import java.util.Random;


public class Cliente {
    public String nombre;
    public String apellido;
    public String RFC;
    private String CURP;
    public String email;
    public LocalDate fechaRegistro;
    public String sucursal;
    public Rol rol;
    public double saldo;
    public Random rand = new Random();
    public String tarjetaDebito;


    public Cliente(String nombre, String apellido, String RFC, String CURP, String email, LocalDate fechaRegistro, String sucursal, String tarjetaDebito) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.RFC = RFC;
        this.CURP = CURP;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.sucursal = sucursal;
        this.rol = rol;
        this.saldo = saldo;
        this.rand = rand;
        this.tarjetaDebito = tarjetaDebito;
    }

    public void generarTarjetaDebito() {
        int digitos1 = rand.nextInt(9);
        int digitos2 = rand.nextInt(9);
        int digitos3 = rand.nextInt(9);
        int digitos4 = rand.nextInt(9);

        System.out.println(String.format("%d %d %d %d", digitos1, digitos2, digitos3, digitos4));
    }


    public void generarTarjetaCredito() {
    }

    //-------------------------SETTER & GETTER-----------------------------------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
