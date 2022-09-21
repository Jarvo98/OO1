package ar.edu.unlp.info.oo1.ej9.cuenta.con.ganchos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CajaDeAhorroTest {

    private CajaDeAhorro cajaDeAhorro;

    @BeforeEach
    public void setUp() {
        this.cajaDeAhorro = new CajaDeAhorro();
        this.cajaDeAhorro.depositar(100);
    }

    @Test
    public void testDepositarValorPositivo() {
        this.cajaDeAhorro.depositar(100);
        assertEquals(196, this.cajaDeAhorro.getSaldo());
    }

    @Test
    public void testDepositarValorNegativo() {
        this.cajaDeAhorro.depositar(-100);
        assertEquals(98, this.cajaDeAhorro.getSaldo());
    }

    @Test
    public void testExtraerValorPositivoConFondosSuficientes() {
        assertTrue(this.cajaDeAhorro.extraer(50));
        assertEquals(47, this.cajaDeAhorro.getSaldo());
    }

    @Test
    public void testExtraerValorPositivoConFondosInsuficientes() {
        assertFalse(this.cajaDeAhorro.extraer(500));
        assertEquals(98, this.cajaDeAhorro.getSaldo());
    }

    @Test
    public void testExtraerValorNegativo() {
        assertFalse(this.cajaDeAhorro.extraer(-500));
        assertEquals(98, this.cajaDeAhorro.getSaldo());
    }

    @Test
    public void testTransferirValorPositivoConFondosSuficientes() {
        CajaDeAhorro cajaDeAhorroTemporal = new CajaDeAhorro();

        assertTrue(this.cajaDeAhorro.transferirACuenta(10, cajaDeAhorroTemporal));
        assertEquals(87.8d, this.cajaDeAhorro.getSaldo());
        assertEquals(9.8d, cajaDeAhorroTemporal.getSaldo());
    }

    @Test
    public void testTransferirValorPositivoConFondosInsuficientes() {
        CajaDeAhorro cajaDeAhorroTemporal = new CajaDeAhorro();

        assertFalse(this.cajaDeAhorro.transferirACuenta(500, cajaDeAhorroTemporal));
        assertEquals(98d, this.cajaDeAhorro.getSaldo());
        assertEquals(0, cajaDeAhorroTemporal.getSaldo());
    }

    @Test
    public void testTransferirValorNegativo() {
        CajaDeAhorro cajaDeAhorroTemporal = new CajaDeAhorro();

        assertFalse(this.cajaDeAhorro.transferirACuenta(-10, cajaDeAhorroTemporal));
        assertEquals(98d, this.cajaDeAhorro.getSaldo());
        assertEquals(0, cajaDeAhorroTemporal.getSaldo());
    }

    @Test
    public void testTransferirEntreCajaDeAhorroYCuentaCorriente() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente();

        assertTrue(this.cajaDeAhorro.transferirACuenta(50, cuentaCorriente));
        assertEquals(47, this.cajaDeAhorro.getSaldo());
        assertEquals(50, cuentaCorriente.getSaldo());
    }
}
