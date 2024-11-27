package tarjetas;

import java.time.LocalDate;

public class Credito extends Tarjeta {
    public Credito(String titular, String numeroTarjeta, String fechaCreacion, double saldo, int cvv, String clabeInter, LocalDate fechaVencimiento, String ultimoMovimiento) {
        super(titular, numeroTarjeta, fechaCreacion, saldo, cvv, clabeInter, fechaVencimiento, ultimoMovimiento);
    }
}
