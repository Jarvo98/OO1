package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CilindroTest {

    private Cilindro cilindro;

    @BeforeEach
    public void setUp() {
        this.cilindro = new Cilindro("Hierro", "Gris", 1, 10);
    }

    @Test
    public void getVolumenTest() {
        Assertions.assertEquals(31.42, this.cilindro.getVolumen(), 0.01);
    }

    @Test
    public void getSuperficieTest() {
        Assertions.assertEquals(69.12, this.cilindro.getSuperficie(), 0.01);
    }
}
