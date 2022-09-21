package ar.edu.unlp.info.oo1.ej9.cuenta.con.ganchos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuentaCorrienteTest {

    private CuentaCorriente cuentaCorriente;

    @BeforeEach
    public void setUp() {
        this.cuentaCorriente = new CuentaCorriente();
        this.cuentaCorriente.setDescubierto(500);
    }

    @Test
    public void testDepositarValorPositivo() {
        this.cuentaCorriente.depositar(100);
        assertEquals(100, this.cuentaCorriente.getSaldo());
    }

    @Test
    public void testDepositarValorNegativo() {
        this.cuentaCorriente.depositar(-100);
        assertEquals(0, this.cuentaCorriente.getSaldo());
    }

    @Test
    public void testExtraerValorPositivoConFondosSuficientes() {
        assertTrue(this.cuentaCorriente.extraer(400));
        assertEquals(-400, this.cuentaCorriente.getSaldo());
    }

    @Test
    public void testExtraerValorPositivoConFondosInsuficientes() {
        assertFalse(this.cuentaCorriente.extraer(600));
        assertEquals(0, this.cuentaCorriente.getSaldo());
    }

    @Test
    public void testExtraerValorNegativo() {
        assertFalse(this.cuentaCorriente.extraer(-500));
        assertEquals(0, this.cuentaCorriente.getSaldo());
    }

    @Test
    public void testTransferirValorPositivoConFondosSuficientes() {
        CuentaCorriente cuentaCorrienteTemporal = new CuentaCorriente();

        assertTrue(this.cuentaCorriente.transferirACuenta(300, cuentaCorrienteTemporal));
        assertEquals(-300, this.cuentaCorriente.getSaldo());
        assertEquals(300, cuentaCorrienteTemporal.getSaldo());
    }

    @Test
    public void testTransferirValorPositivoConFondosInsuficientes() {
        CuentaCorriente cuentaCorrienteTemporal = new CuentaCorriente();

        assertFalse(this.cuentaCorriente.transferirACuenta(600, cuentaCorrienteTemporal));
        assertEquals(0, this.cuentaCorriente.getSaldo());
        assertEquals(0, cuentaCorrienteTemporal.getSaldo());
    }

    @Test
    public void testTransferirValorNegativo() {
        CuentaCorriente cuentaCorrienteTemporal = new CuentaCorriente();

        assertFalse(this.cuentaCorriente.transferirACuenta(-600, cuentaCorrienteTemporal));
        assertEquals(0, this.cuentaCorriente.getSaldo());
        assertEquals(0, cuentaCorrienteTemporal.getSaldo());
    }

    @Test
    public void testTransferirEntreCuentaCorrienteYCajaDeAhorro() {
        CajaDeAhorro cajaDeAhorro = new CajaDeAhorro();

        this.cuentaCorriente.depositar(500);
        assertTrue(this.cuentaCorriente.transferirACuenta(500, cajaDeAhorro));
        assertEquals(0, this.cuentaCorriente.getSaldo());
        assertEquals(490, cajaDeAhorro.getSaldo());
    }
}
