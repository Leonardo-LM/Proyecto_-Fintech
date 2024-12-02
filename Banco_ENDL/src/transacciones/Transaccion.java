package transacciones;

import usuarios.clientes.Cliente;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaccion implements Serializable {
    // datos como cliente, tarjeta, fecha y hora
    public String titular;
    public String numeroTarjeta;
    public double saldoAnterior;
    public double saldoAtual;
    LocalDateTime momentoDeOperacion;
    public String operación;

    public Transaccion(String titular, String numeroTarjeta, double saldoAnterior,double saldoAtual, LocalDateTime momentoDeOperacion, String operación) {
        this.titular = titular;
        this.numeroTarjeta = numeroTarjeta;
        this.saldoAnterior = saldoAnterior;
        this.saldoAtual = saldoAtual;
        this.momentoDeOperacion = momentoDeOperacion;
        this.operación = operación;
    }


    public String getTitular() { return titular; }

    public String getNumeroTarjeta() { return numeroTarjeta; }

    public double getSaldoAnterior() { return saldoAnterior; }

    public double getSaldoAtual() { return saldoAtual; }

    public LocalDateTime getMomentoDeOperacion() { return momentoDeOperacion; }

    public String getOperación() { return operación; }
}
