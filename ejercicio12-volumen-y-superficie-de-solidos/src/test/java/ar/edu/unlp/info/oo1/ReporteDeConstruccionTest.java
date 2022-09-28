package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReporteDeConstruccionTest {

    private ReporteDeConstruccion reporteDeConstruccion;

    @BeforeEach
    public void setUp() {
        this.reporteDeConstruccion = new ReporteDeConstruccion();
    }

    @Test
    public void volumenDeMaterialConPiezasTest() {
        this.agregarPiezas();
        assertEquals(36604.72, this.reporteDeConstruccion.volumenDeMaterial("Hierro"), 0.01);
    }

    @Test
    public void volumenDeMaterialSinPiezasTest() {
        assertEquals(0, this.reporteDeConstruccion.volumenDeMaterial("Hierro"));
    }

    @Test
    public void superficieDeColorConPiezasTest() {
        this.agregarPiezas();
        assertEquals(8868.14, this.reporteDeConstruccion.superficieDeColor("Verde"), 0.01);
    }

    @Test
    public void superficieDeColorSinPiezasTest() {
        assertEquals(0, this.reporteDeConstruccion.superficieDeColor("Verde"));
    }

    private void agregarPiezas() {
        this.reporteDeConstruccion.agregarPieza(new Cilindro("Hierro", "Rojo", 10, 100)); // volumen: 31415.93
        this.reporteDeConstruccion.agregarPieza(new Esfera("Hierro", "Rojo", 10)); // volumen: 4188.79
        this.reporteDeConstruccion.agregarPieza(new PrismaRectangular("Hierro", "Rojo", 20, 10, 5)); // volumen: 1000
        this.reporteDeConstruccion.agregarPieza(new Cilindro("Bronce", "Verde", 10, 100)); // superficie: 6911.50
        this.reporteDeConstruccion.agregarPieza(new Esfera("Bronce", "Verde", 10)); // superficie: 1256.64
        this.reporteDeConstruccion.agregarPieza(new PrismaRectangular("Bronce", "Verde", 20, 10, 5)); // superficie: 700
    }
}
