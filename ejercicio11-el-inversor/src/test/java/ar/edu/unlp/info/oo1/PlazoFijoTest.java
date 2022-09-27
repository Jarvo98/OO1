package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlazoFijoTest {

    private PlazoFijo inversion;
    private final Helper helper = Helper.getInstance();

    @BeforeEach
    public void setUp() {
        this.inversion = new PlazoFijo(this.helper.getMonto(), this.helper.getPorcentaje(), this.helper.getFecha());
    }

    @Test
    public void testValorActual() {
        assertEquals(this.helper.calcularTotal(), this.inversion.valorActual());
    }
}
