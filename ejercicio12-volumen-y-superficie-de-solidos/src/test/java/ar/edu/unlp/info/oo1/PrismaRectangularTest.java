package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrismaRectangularTest {

    private PrismaRectangular prismaRectangular;

    @BeforeEach
    public void setUp() {
        this.prismaRectangular = new PrismaRectangular("Hierro", "Gris", 5, 3, 1);
    }

    @Test
    public void getVolumenTest() {
        Assertions.assertEquals(15, this.prismaRectangular.getVolumen());
    }

    @Test
    public void getSuperficieTest() {
        Assertions.assertEquals(46, this.prismaRectangular.getSuperficie());
    }

    @Test
    public void esDeEsteColorTest() {
        Assertions.assertTrue(this.prismaRectangular.esDeEsteColor("Gris"));
        Assertions.assertFalse(this.prismaRectangular.esDeEsteColor("Rojo"));
    }

    @Test
    public void esDeEsteMaterialTest() {
        Assertions.assertTrue(this.prismaRectangular.esDeEsteMaterial("Hierro"));
        Assertions.assertFalse(this.prismaRectangular.esDeEsteColor("Bronce"));
    }
}