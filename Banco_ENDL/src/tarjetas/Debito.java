package tarjetas;

import usuarios.Cliente;

import java.time.LocalDate;

public class Debito extends Tarjeta {
    public Debito(Cliente titular, String numeroTarjeta, LocalDate fechaCreacion, double saldo, String cvv, String clabeInter, LocalDate fechaVencimiento) {
        super(titular, numeroTarjeta, fechaCreacion, saldo, cvv, clabeInter, fechaVencimiento);
    }
}
