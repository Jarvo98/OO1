package ar.edu.unlp.info.oo1.ejercicio7.method.lookup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GerenteTest {
    private Gerente alan;

    @BeforeEach
    public void setUp() {
        this.alan = new Gerente("Alan Turing");
    }

    @Test
    public void testAportes() {
        assertEquals(this.alan.aportes(), 2850);
    }

    @Test
    public void testSueldoBasico() {
        assertEquals(this.alan.sueldoBasico(), 67850);
    }
}