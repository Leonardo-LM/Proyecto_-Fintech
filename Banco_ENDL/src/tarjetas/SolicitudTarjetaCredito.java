package tarjetas;

import java.io.Serializable;

public class SolicitudTarjetaCredito implements Serializable {
    String idClienteSolicitador;
    String titular;
    Boolean tarjetaAutorizada;
    Double saldoEnSuTarjetaDebito;

    public SolicitudTarjetaCredito(String idClienteSolicitador, String titular, Boolean tarjetaAutorizada, Double saldoEnSuTarjetaDebito) {
        this.idClienteSolicitador = idClienteSolicitador;
        this.titular = titular;
        this.tarjetaAutorizada = tarjetaAutorizada;
        this.saldoEnSuTarjetaDebito = saldoEnSuTarjetaDebito;
    }

    public String mostrarDatos() {
        return String.format(
                "----- Solicitud de Tarjeta de Crédito -----\n" +
                        "ID Cliente Solicitante: %s\n" +
                        "Titular: %s\n" +
                        "Tarjeta Autorizada: %b\n" +
                        "Saldo en Tarjeta de Débito: $%.2f\n",
                idClienteSolicitador,
                titular,
                tarjetaAutorizada,
                saldoEnSuTarjetaDebito
        );
    }

    public String getIdClienteSolicitador() {
        return idClienteSolicitador;
    }

    public void setIdClienteSolicitador(String idClienteSolicitador) {
        this.idClienteSolicitador = idClienteSolicitador;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Boolean getTarjetaAutorizada() {
        return tarjetaAutorizada;
    }

    public void setTarjetaAutorizada(Boolean tarjetaAutorizada) {
        this.tarjetaAutorizada = tarjetaAutorizada;
    }

    public Double getSaldoEnSuTarjetaDebito() {
        return saldoEnSuTarjetaDebito;
    }

    public void setSaldoEnSuTarjetaDebito(Double saldoEnSuTarjetaDebito) {
        this.saldoEnSuTarjetaDebito = saldoEnSuTarjetaDebito;
    }

    @Override
    public String toString() {
        return "SolicitudTarjetaCredito{" +
                "idClienteSolicitador='" + idClienteSolicitador + '\'' +
                ", titular='" + titular + '\'' +
                ", tarjetaAutorizada=" + tarjetaAutorizada +
                ", saldoEnSuTarjetaDebito=" + saldoEnSuTarjetaDebito +
                '}';
    }
}
