package tarjetas;

import usuarios.Cliente;

import java.time.LocalDate;

public class Credito extends Tarjeta {
    public Credito(Cliente titular, String numeroTarjeta, LocalDate fechaCreacion, double saldo, String cvv, String clabeInter, LocalDate fechaVencimiento) {
        super(titular, numeroTarjeta, fechaCreacion, saldo, cvv, clabeInter, fechaVencimiento);
    }
}
