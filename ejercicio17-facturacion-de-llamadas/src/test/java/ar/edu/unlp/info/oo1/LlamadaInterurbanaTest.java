package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDateTime;

public class LlamadaInterurbanaTest {

    @Test
    public void calcularCostoTestParaDistanciasMenoresA100() {
        LlamadaInterurbana llamadaInterurbanaCorta = new LlamadaInterurbana(LocalDateTime.of(2022, 1, 15, 8, 30), 10, 11111111, 22222222, 50);

        assertEquals(25, llamadaInterurbanaCorta.calcularCosto());
    }

    @Test
    public void calcularCostoTestParaDistanciaMayorOIgualA100yMenorOIgualA500() {
        LlamadaInterurbana llamadaInterurbanaMedia = new LlamadaInterurbana(LocalDateTime.of(2022, 1, 15, 8, 30), 10, 11111111, 22222222, 150);

        assertEquals(30, llamadaInterurbanaMedia.calcularCosto());
    }

    @Test
    public void calcularCostoTestParaDistanciasMayoresA500() {
        LlamadaInterurbana llamadaInterurbanaLarga = new LlamadaInterurbana(LocalDateTime.of(2022, 1, 15, 8, 30), 10, 11111111, 22222222, 550);

        assertEquals(35, llamadaInterurbanaLarga.calcularCosto());
    }

    @Test
    public void calcularCostoTestParaExtremos() {
        LlamadaInterurbana llamadaInterurbana99 = new LlamadaInterurbana(LocalDateTime.of(2022, 1, 15, 8, 30), 10, 11111111, 22222222, 99);
        LlamadaInterurbana llamadaInterurbana100 = new LlamadaInterurbana(LocalDateTime.of(2022, 1, 15, 8, 30), 10, 11111111, 22222222, 100);
        LlamadaInterurbana llamadaInterurbana499 = new LlamadaInterurbana(LocalDateTime.of(2022, 1, 15, 8, 30), 10, 11111111, 22222222, 499);
        LlamadaInterurbana llamadaInterurbana500 = new LlamadaInterurbana(LocalDateTime.of(2022, 1, 15, 8, 30), 10, 11111111, 22222222, 500);
        LlamadaInterurbana llamadaInterurbana501 = new LlamadaInterurbana(LocalDateTime.of(2022, 1, 15, 8, 30), 10, 11111111, 22222222, 501);

        assertEquals(25, llamadaInterurbana99.calcularCosto());
        assertEquals(30, llamadaInterurbana100.calcularCosto());
        assertEquals(30, llamadaInterurbana499.calcularCosto());
        assertEquals(30, llamadaInterurbana500.calcularCosto());
        assertEquals(35, llamadaInterurbana501.calcularCosto());
    }
}
