package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InversorTest {

    private Inversor inversor;
    private final Helper helper = Helper.getInstance();

    @BeforeEach
    public void setUp() {
        this.inversor =
                new Inversor("Jesus")
                .agregarInversion(new InversionEnAcciones("Meta", 10, 300))
                .agregarInversion(new PlazoFijo(this.helper.getMonto(), this.helper.getPorcentaje(), this.helper.getFecha()));
    }

    @Test
    public void testAgregarInversion() {
        assertEquals(2, this.inversor.getCantidadDeInversiones());
    }

    @Test
    public void testValorActual() {
        assertEquals(this.calcularTotal(), this.inversor.valorActual());
    }

    @Test
    public void testEliminarInversiones() {
        this.inversor.eliminarInversiones();
        assertEquals(0, this.inversor.getCantidadDeInversiones());
        assertEquals(0, this.inversor.valorActual());
    }

    private double calcularTotal() {
        return (10 * 300) + this.helper.calcularTotal();
    }
}
