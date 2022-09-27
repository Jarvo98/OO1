package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InversionEnAccionesTest {

    private InversionEnAcciones inversion;

    @BeforeEach
    public void setUp() {
        this.inversion = new InversionEnAcciones("Google", 20, 500);
    }

    @Test
    public void testValorActual() {
        assertEquals(10000, this.inversion.valorActual());
    }
}
