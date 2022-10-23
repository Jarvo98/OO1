package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LlamadaLocalTest {

    private LlamadaLocal llamadaLocal;

    @BeforeEach
    public void setUp() {
        this.llamadaLocal = new LlamadaLocal(LocalDateTime.of(2022, 1, 15, 8, 30), 10, 11111111, 22222222);
    }

    @Test
    public void calcularCostoTest() {
        assertEquals(10, this.llamadaLocal.calcularCosto());
    }

    @Test
    public void fueHechaEnPeriodoTest() {
        assertTrue(this.llamadaLocal.fueHechaEnPeriodo(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 31)));
        assertFalse(this.llamadaLocal.fueHechaEnPeriodo(LocalDate.of(2022, 2, 1), LocalDate.of(2022, 2, 28)));
    }
}
