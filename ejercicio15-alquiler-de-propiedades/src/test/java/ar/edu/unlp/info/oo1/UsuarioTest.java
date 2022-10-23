package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        this.usuario = new Usuario("Jesus Rojas", "Calle 10 #1859 PH", 95929560);
    }

    @Test
    public void obtenerPropiedadesNoAlquiladasEnPeriodoTest() {
        Propiedad propiedad = this.usuario.registrarPropiedad("Lujoso departamento",
                "Lindo lugar cerca de la playa", 10000, "Calle 20 #600");
        ArrayList<Propiedad> listaDePropiedades = new ArrayList<>();
        listaDePropiedades.add(propiedad);

        assertEquals(listaDePropiedades,
                this.usuario.obtenerPropiedadesNoAlquiladasEnPeriodo(new DateLapse(
                        LocalDate.of(2022, 10, 7), LocalDate.of(2022, 10, 14))));
    }

    @Test
    public void calcularIngresosDelPeriodoTest() {
        Usuario inquilino =
                new Usuario("Gustavo Rojas", "Rivadavia #3356", 95929561);

        inquilino.hacerUnaReserva(
                this.usuario.registrarPropiedad(
                        "Lujoso departamento 1", "Lindo lugar cerca de la playa 1"),
                100, "Calle 10 #600",
                new DateLapse(LocalDate.of(2022, 10, 10), LocalDate.of(2022, 10, 16)));
        inquilino.hacerUnaReserva(
                this.usuario.registrarPropiedad(
                        "Lujoso departamento 2", "Lindo lugar cerca de la playa 2"),
                100, "Calle 20 #600",
                new DateLapse(LocalDate.of(2022, 10, 17), LocalDate.of(2022, 10, 23)));
        inquilino.hacerUnaReserva(
                this.usuario.registrarPropiedad(
                        "Lujoso departamento 3", "Lindo lugar cerca de la playa 3"),
                100, "Calle 30 #600",
                new DateLapse(LocalDate.of(2022, 10, 3), LocalDate.of(2022, 10, 9)));

        assertEquals(1500,
                this.usuario.calcularIngresosDelPeriodo(new DateLapse(
                        LocalDate.of(2022, 10, 7), LocalDate.of(2022, 10, 21))));
    }
}
