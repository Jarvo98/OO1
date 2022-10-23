package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropiedadTest {
    private Propiedad propiedad;

    @BeforeEach
    public void setUp() {
        this.propiedad = new Propiedad("Lujoso departamento",
                "Lindo lugar cerca de la playa", 10000, "Calle 20 #600");
    }

    @Test
    public void estaAlquiladaEnPeriodoTest() {
        Reserva reserva = new Reserva(this.propiedad,
                new DateLapse(LocalDate.of(2022, 10, 10), LocalDate.of(2022, 10, 16)));

        assertTrue(this.propiedad.estaAlquiladaEnPeriodo(
                new DateLapse(LocalDate.of(2022, 10, 10), LocalDate.of(2022, 10, 16))))
    }
}
