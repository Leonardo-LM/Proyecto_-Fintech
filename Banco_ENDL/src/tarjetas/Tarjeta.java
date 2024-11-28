package tarjetas;

import java.time.LocalDate;

public class Tarjeta {
    public Cliente titular;
    public String numeroTarjeta;
    public LocalDate fechaCreacion;
    public double saldo;
    public String cvv;
    public String clabeInter;
    public LocalDate fechaVencimiento;
    //public String ultimoMovimiento;


    public Tarjeta(Cliente titular, String numeroTarjeta, LocalDate fechaCreacion, double saldo, String cvv, String clabeInter, LocalDate fechaVencimiento) {
        this.titular = titular;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCreacion = fechaCreacion;
        this.saldo = saldo;
        this.cvv = cvv;
        this.clabeInter = clabeInter;
        this.fechaVencimiento = fechaVencimiento;
        //this.ultimoMovimiento = ultimoMovimiento;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getClabeInter() {
        return clabeInter;
    }

    public void setClabeInter(String clabeInter) {
        this.clabeInter = clabeInter;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

   /* public String getUltimoMovimiento() {
        return ultimoMovimiento;
    }

    public void setUltimoMovimiento(String ultimoMovimiento) {
        this.ultimoMovimiento = ultimoMovimiento;
    }

    */
}
