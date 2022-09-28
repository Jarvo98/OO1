package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EsferaTest {

    private Esfera esfera;

    @BeforeEach
    public void setUp() {
        this.esfera = new Esfera("Hierro", "Gris", 1);
    }

    @Test
    public void getVolumenTest() {
        Assertions.assertEquals(4.19, this.esfera.getVolumen(), 0.01);
    }

    @Test
    public void getSuperficieTest() {
        Assertions.assertEquals(12.57, this.esfera.getSuperficie(), 0.01);
    }

    @Test
    public void esDeEsteColorTest() {
        Assertions.assertTrue(this.esfera.esDeEsteColor("Gris"));
        Assertions.assertFalse(this.esfera.esDeEsteColor("Rojo"));
    }

    @Test
    public void esDeEsteMaterialTest() {
        Assertions.assertTrue(this.esfera.esDeEsteMaterial("Hierro"));
        Assertions.assertFalse(this.esfera.esDeEsteColor("Bronce"));
    }
}