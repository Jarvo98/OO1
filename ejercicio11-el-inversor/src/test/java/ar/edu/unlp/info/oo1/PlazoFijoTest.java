package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlazoFijoTest {

    private PlazoFijo inversion;

    @BeforeEach
    public void setUp() {
        this.inversion = new PlazoFijo(100, 1, LocalDate.of(2022, 9, 26));
    }

    @Test
    public void testValorActual() {
        assertEquals(104, this.inversion.valorActual());
    }
}
