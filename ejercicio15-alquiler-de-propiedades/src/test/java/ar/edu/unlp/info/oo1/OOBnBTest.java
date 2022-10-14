package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OOBnBTest {
    private OOBnB ooBnB;
    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        this.ooBnB = new OOBnB();
        this.usuario = this.ooBnB.registrarUsuario(
                "Jesus Rojas", "Calle 10 #1859 PH", 95929560);
    }

    @Test
    public void registrarUsuarioTest() {
        assertTrue(this.ooBnB.estaRegistradoElUsuario(this.usuario));
        assertFalse(this.ooBnB.estaRegistradoElUsuario(
                new Usuario("Gustavo Rojas", "Rivadavia 3346", 95929102)));
    }

    @Test
    public void buscarPropiedadesDisponiblesEnPeriodoTestSinDisponibilidad() {
        assertEquals(new ArrayList<Propiedad>(),
                this.ooBnB.buscarPropiedadesDisponiblesEnPeriodo(new DateLapse(
                        LocalDate.of(2022, 10, 1), LocalDate.of(2022, 10, 11))));
    }

    @Test
    void buscarPropiedadesDisponiblesEnPeriodoTestConDisponibilidad() {
        Propiedad propiedad = this.usuario.registrarPropiedad("Lujoso departamento",
                "Lindo lugar cerca de la playa", 10000, "Calle 20 #600");
        ArrayList<Propiedad> expected = new ArrayList<Propiedad>();
        expected.add(propiedad);

        assertEquals(expected,
                this.ooBnB.buscarPropiedadesDisponiblesEnPeriodo(new DateLapse(
                        LocalDate.of(2022, 10, 1), LocalDate.of(2022, 10, 11))));
    }
}
