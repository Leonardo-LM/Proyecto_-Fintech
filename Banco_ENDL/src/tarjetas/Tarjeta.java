package tarjetas;

import java.time.LocalDate;

public class Tarjeta {
    public String titular;
    public String numeroTarjeta;
    public String fechaCreacion;
    public double saldo;
    public int cvv;
    public String clabeInter;
    public LocalDate fechaVencimiento;
    public String ultimoMovimiento;


    public Tarjeta(String titular, String numeroTarjeta, String fechaCreacion, double saldo, int cvv, String clabeInter, LocalDate fechaVencimiento, String ultimoMovimiento) {
        this.titular = titular;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCreacion = fechaCreacion;
        this.saldo = saldo;
        this.cvv = cvv;
        this.clabeInter = clabeInter;
        this.fechaVencimiento = fechaVencimiento;
        this.ultimoMovimiento = ultimoMovimiento;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
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

    public String getUltimoMovimiento() {
        return ultimoMovimiento;
    }

    public void setUltimoMovimiento(String ultimoMovimiento) {
        this.ultimoMovimiento = ultimoMovimiento;
    }
}
