package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ReciboDeCobroTest {

    private ReciboDeCobro reciboDeCobro;

    private void crearEmpleadoConAntiguedad(LocalDate fechaDeInicio) {
        return new Empleado("Jesus", "Rojas", 20959295604L, LocalDate.of(1998, 1, 13), false, false, fechaDeInicio);
    }

    private ReciboDeCobro crearReciboDeCobroDeEmpleadoDePlanta(LocalDate fechaDeInicio) {
        Empleado empleado = this.crearEmpleadoConAntiguedad(fechaDeInicio);

        empleado.cargarContratoDePlanta(LocalDate.of(2023, 4, 1), 1000, 100, 100);

        return new ReciboDeCobro(empleado);
    }

    private ReciboDeCobro crearReciboDeCobroDeEmpleadoPorHoras(LocalDate fechaDeInicio) {
        Empleado empleado = this.crearEmpleadoConAntiguedad(fechaDeInicio);

        empleado.cargarContratoPorHora(LocalDate.of(2023, 4, 1), LocalDate.of(2023, 5, 31), 100, 160);

        return new ReciboDeCobro(empleado);
    }

    @Test
    public void calcularMontoTotalTestConEmpleadoDePlanta() {
        this.reciboDeCobro = this.crearReciboDeCobroDeEmpleadoDePlanta();

        assertEquals(1000, this.reciboDeCobro.calcularMontoTotal(LocalDate.of(2023, 4, 1)));
    }

    @Test
    public void calcularMontoTotalTestConEmpleadoPorHoras() {
        this.reciboDeCobro = this.crearReciboDeCobroDeEmpleadoPorHoras(LocalDate.of(2023, 4, 1));

        assertEquals(1600, this.reciboDeCobro.calcularMontoTotal());
    }

}
