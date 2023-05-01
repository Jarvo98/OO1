package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class SistemaTest {

    private Sistema sistema;
    private Empleado empleado1;
    private Empleado empleado2;
    private Empleado empleado3;

    @BeforeEach
    public void setUp() {
        this.sistema = new Sistema();
        this.empleado1 = this.sistema.darDeAltaEmpleado("Jesus", "Rojas", 20959295604L, LocalDate.of(1998, 1, 13), false, false);
        this.empleado2 = this.sistema.darDeAltaEmpleado("Gustavo", "Rojas", 20959295614L, LocalDate.of(1998, 1, 13), false, false);
        this.empleado3 = this.sistema.darDeAltaEmpleado("Luis", "Rojas", 20959295624L, LocalDate.of(1995, 7, 19), false, false);
    }

    @Test
    public void obtenerEmpleadosConContratosVencidosTestSinVencimientos() {
        this.sistema.cargarContratoDePlantaParaEmpleado(
                this.empleado1,
                LocalDate.of(2023, 4, 1),
                100000,
                10000,
                10000
        );

        this.sistema.cargarContratoPorHoraParaEmpleado(
                this.empleado2,
                LocalDate.of(2023, 4, 1),
                LocalDate.of(2023, 5, 31),
                1000,
                320
        );

        Assertions.assertTrue(this.sistema.obtenerEmpleadosConContratosVencidos().isEmpty());
    }

    @Test
    public void obtenerEmpleadosConContratosVencidosTestConVencimientos() {
        this.sistema.cargarContratoDePlantaParaEmpleado(
                this.empleado1,
                LocalDate.of(2023, 4, 1),
                100000,
                10000,
                10000
        );

        this.sistema.cargarContratoPorHoraParaEmpleado(
                this.empleado2,
                LocalDate.of(2023, 4, 1),
                LocalDate.of(2023, 5, 31),
                1000,
                320
        );

        this.sistema.cargarContratoPorHoraParaEmpleado(
                this.empleado3,
                LocalDate.of(2023, 4, 1),
                LocalDate.of(2023, 4, 15),
                1000,
                320
        );

        List<Empleado> empleadosConContratoVencido =  this.sistema.obtenerEmpleadosConContratosVencidos();

        Assertions.assertEquals(1, empleadosConContratoVencido.size());
        Assertions.assertTrue(empleadosConContratoVencido.contains(this.empleado3));
    }

    @Test
    public void obtenerEmpleadosConContratosVencidosTestConVencimientosEnExtremos() {
        this.sistema.cargarContratoPorHoraParaEmpleado(
                this.empleado1,
                LocalDate.of(2023, 4, 1),
                LocalDate.now().minusDays(1),
                1000,
                320
        );


        this.sistema.cargarContratoPorHoraParaEmpleado(
                this.empleado2,
                LocalDate.of(2023, 4, 1),
                LocalDate.now(),
                1000,
                320
        );

        Assertions.assertEquals(1, this.sistema.obtenerEmpleadosConContratosVencidos().size());
        Assertions.assertTrue(this.sistema.obtenerEmpleadosConContratosVencidos().contains(this.empleado1));
    }

}
