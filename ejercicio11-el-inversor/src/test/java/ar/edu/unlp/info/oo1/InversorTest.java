package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class InversorTest {

    private Inversor inversor;

    @BeforeEach
    public void setUp() {
        this.inversor =
                new Inversor("Jesus")
                .agregarInversion(new InversionEnAcciones("Meta", 10, 300))
                .agregarInversion(new PlazoFijo(100, 1, LocalDate.of(2022, 9, 26)));
    }

    @Test
    public void testAgregarInversion() {
        assertEquals(2, this.inversor.getCantidadDeInversiones());
    }

    @Test
    public void testValorActual() {
        assertEquals(3104, this.inversor.valorActual());
    }

    @Test
    public void testEliminarInversiones() {
        this.inversor.eliminarInversiones();
        assertEquals(0, this.inversor.getCantidadDeInversiones());
        assertEquals(0, this.inversor.valorActual());
    }
}
