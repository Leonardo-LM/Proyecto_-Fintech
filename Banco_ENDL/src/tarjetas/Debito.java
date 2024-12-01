package tarjetas;

import usuarios.clientes.Cliente;

import java.time.LocalDate;

public class Debito extends Tarjeta {
    public Debito(Cliente titular, String numeroTarjeta, LocalDate fechaCreacion, double saldo, String cvv, String clabeInter, LocalDate fechaVencimiento) {
        super(titular, numeroTarjeta, fechaCreacion, saldo, cvv, clabeInter, fechaVencimiento);
    }
    public String mostrarDatos() {
        return String.format(
                "----- Datos de la Tarjeta de Débito -----\n" +
                        "Titular: %s\n" +
                        "Número de Tarjeta: %s\n" +
                        "Fecha de Creación: %s\n" +
                        "Saldo: $%.2f\n" +
                        "CVV: %s\n" +
                        "CLABE Interbancaria: %s\n" +
                        "Fecha de Vencimiento: %s\n",
                getTitular().getNombre(),
                getNumeroTarjeta(),
                getFechaCreacion(),
                getSaldo(),
                getCvv(),
                getClabeInter(),
                getFechaVencimiento()
        );
    }
}
