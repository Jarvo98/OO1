package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PersonaJuridicaTest {

    private PersonaJuridica personaJuridica;

    @BeforeEach
    public void setUp() {
        this.personaJuridica = new PersonaJuridica("Jesus", "Calle 10", 11111111, 20959295604, "Sociedad Anonima");
    }

    @Test
    public void facturarTestConFacturasEnPeriodo() {
        this.personaJuridica.registrarLlamadaLocal(LocalDateTime.of(2022, 1, 15, 12, 10, 10), 11, 22222222);
        this.personaJuridica.registrarLlamadaInterurbana(LocalDateTime.of(2022, 2, 15, 12, 10, 10), 3, 22222222, 50);

        assertEquals(22, this.personaJuridica.facturar(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 2, 28)).getMontoTotal());
    }

    @Test
    public void facturarTestSinFacturasEnPeriodo() {
        assertEquals(0, this.personaJuridica.facturar(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 2, 28)).getMontoTotal());
    }

    @Test
    public void facturarTestConFacturasEnExtremos() {
        this.personaJuridica.registrarLlamadaLocal(LocalDateTime.of(2022, 1, 1, 0, 0, 1), 11, 22222222);
        this.personaJuridica.registrarLlamadaInterurbana(LocalDateTime.of(2022, 2, 28, 23, 59, 59), 3, 22222222, 50);

        assertEquals(22, this.personaJuridica.facturar(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 2, 28)).getMontoTotal());
    }

}
