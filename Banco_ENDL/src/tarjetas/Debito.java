package tarjetas;

import java.time.LocalDate;

public class Debito extends Tarjeta {
    public Debito(String titular, String numeroTarjeta, String fechaCreacion, double saldo, int cvv, String clabeInter, LocalDate fechaVencimiento, String ultimoMovimiento) {
        super(titular, numeroTarjeta, fechaCreacion, saldo, cvv, clabeInter, fechaVencimiento, ultimoMovimiento);
    }
}
