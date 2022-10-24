package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PersonaFisicaTest {

    private PersonaFisica personaFisica;

    @BeforeEach
    public void setUp() {
        this.personaFisica = new PersonaFisica("Jesus", "Calle 10", 11111111,95929560);
    }

    @Test
    public void facturarTestConFacturasEnPeriodo() {
        this.personaFisica.registrarLlamadaLocal(LocalDateTime.of(2022, 1, 15, 12, 10, 10), 11, 22222222);
        this.personaFisica.registrarLlamadaInterurbana(LocalDateTime.of(2022, 2, 15, 12, 10, 10), 3, 22222222, 50);

        assertEquals(19.8, this.personaFisica.facturar(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 2, 28)).getMontoTotal());
    }

    @Test
    public void facturarTestSinFacturasEnPeriodo() {
        assertEquals(0, this.personaFisica.facturar(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 2, 28)).getMontoTotal());
    }

    @Test
    public void facturarTestConFacturasEnExtremos() {
        this.personaFisica.registrarLlamadaLocal(LocalDateTime.of(2022, 1, 1, 0, 0, 1), 11, 22222222);
        this.personaFisica.registrarLlamadaInterurbana(LocalDateTime.of(2022, 2, 28, 23, 59, 59), 3, 22222222, 50);

        assertEquals(19.8, this.personaFisica.facturar(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 2, 28)).getMontoTotal());
    }

}
