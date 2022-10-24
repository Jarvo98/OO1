package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SistemaTest {

    private Sistema sistema;
    private PersonaFisica personaFisica;

    @BeforeEach
    public void setUp() {
        this.sistema = new Sistema();
        this.sistema.agregarNumero(11111111);
        this.sistema.agregarNumero(22222222);
        this.sistema.agregarNumero(33333333);
        this.personaFisica = this.sistema.darDeAltaAPersonaFisica("Jesus", "Calle 10", 95929560);
    }

    @Test
    public void facturarAClienteTestConFacturasEnPeriodo() {
        this.sistema.registrarLlamadaLocal(LocalDateTime.of(2022, 1, 15, 12, 10, 10), 11, 11111111, 22222222);
        this.sistema.registrarLlamadaInterurbana(LocalDateTime.of(2022, 2, 15, 12, 10, 10), 3, 11111111, 22222222, 50);
        Factura factura = this.sistema.facturarACliente(this.personaFisica, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 2, 28));

        assertEquals(19.8, factura.getMontoTotal());
    }

    @Test
    public void facturarAClienteTestSinFacturasEnPeriodo() {
        Factura factura = this.sistema.facturarACliente(this.personaFisica, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 2, 28));

        assertEquals(0, factura.getMontoTotal());
    }

    @Test
    public void facturarAClienteTestConFacturasEnExtremos() {
        this.sistema.registrarLlamadaLocal(LocalDateTime.of(2022, 1, 1, 0, 0, 1), 11, 11111111, 22222222);
        this.sistema.registrarLlamadaInterurbana(LocalDateTime.of(2022, 2, 28, 23, 59, 59), 3, 11111111, 2222222, 50);
        this.sistema.registrarLlamadaLocal(LocalDateTime.of(2021, 12, 31, 23, 59, 59), 11, 11111111, 22222222);
        this.sistema.registrarLlamadaInterurbana(LocalDateTime.of(2022, 3, 1, 0, 0, 1), 3, 11111111, 22222222, 50);
        Factura factura = this.sistema.facturarACliente(this.personaFisica, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 2, 28));

        assertEquals(19.8, factura.getMontoTotal());
    }
}
