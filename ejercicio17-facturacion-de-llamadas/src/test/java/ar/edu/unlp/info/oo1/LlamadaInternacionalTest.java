package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

public class LlamadaInternacionalTest {

    @Test
    public void calcularCostoTestEnHorarioDiurno() {
        LlamadaInternacional llamadaInternacionalDiurna = new LlamadaInternacional(LocalDateTime.of(2022, 1, 15, 12,0), 10, 11111111, 22222222, "Argentina", "Venezuela");

        assertEquals(40, llamadaInternacionalDiurna.calcularCosto());
    }

    @Test
    public void calcularCostoTestEnHorarioNocturno() {
        LlamadaInternacional llamadaInternacionalNocturna = new LlamadaInternacional(LocalDateTime.of(2022, 1, 15, 22,0), 10, 11111111, 22222222, "Argentina", "Venezuela");

        assertEquals(30, llamadaInternacionalNocturna.calcularCosto());
    }

    @Test
    public void calcularCostoTestEnExtremos() {
        LlamadaInternacional llamadaInternacionalCasiDiurna = new LlamadaInternacional(LocalDateTime.of(2022, 1, 15, 7,59,59), 10, 11111111, 22222222, "Argentina", "Venezuela");
        LlamadaInternacional llamadaInternacionalDiurna = new LlamadaInternacional(LocalDateTime.of(2022, 1, 15, 8,0,0), 10, 11111111, 22222222, "Argentina", "Venezuela");
        LlamadaInternacional llamadaInternacionalCasiNocturna = new LlamadaInternacional(LocalDateTime.of(2022, 1, 15, 19,59,59), 10, 11111111, 22222222, "Argentina", "Venezuela");
        LlamadaInternacional llamadaInternacionalNocturna = new LlamadaInternacional(LocalDateTime.of(2022, 1, 15, 20,0,0), 10, 11111111, 22222222, "Argentina", "Venezuela");

        assertEquals(30, llamadaInternacionalCasiDiurna.calcularCosto());
        assertEquals(40, llamadaInternacionalDiurna.calcularCosto());
        assertEquals(40, llamadaInternacionalCasiNocturna.calcularCosto());
        assertEquals(30, llamadaInternacionalNocturna.calcularCosto());
    }

}
