package tarjetas;

import usuarios.clientes.Cliente;

import java.io.Serializable;
import java.time.LocalDate;

public class Credito extends Tarjeta implements Serializable {
    public Credito(Cliente titular, String numeroTarjeta, LocalDate fechaCreacion, double saldo, String cvv, String clabeInter, LocalDate fechaVencimiento) {
        super(titular, numeroTarjeta, fechaCreacion, saldo, cvv, clabeInter, fechaVencimiento);
    }

    @Override
    public String toString() {
        return "Credito{" +
                "titular=" + titular +
                ", numeroTarjeta='" + numeroTarjeta + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", saldo=" + saldo +
                ", cvv='" + cvv + '\'' +
                ", clabeInter='" + clabeInter + '\'' +
                ", fechaVencimiento=" + fechaVencimiento +
                '}';
    }
}
