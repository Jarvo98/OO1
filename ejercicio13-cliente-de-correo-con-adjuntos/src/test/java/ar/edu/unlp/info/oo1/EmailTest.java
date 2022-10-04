package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmailTest {

    private Email email;

    @BeforeEach
    public void setUp() {
        this.email = new Email("cada", "daca");
        this.email.agregarAdjunto(new Archivo("1234"));
        this.email.agregarAdjunto(new Archivo("1234"));
    }

    @Test
    public void espacioOcupadoTest() {
        assertEquals(16, this.email.espacioOcupado());
    }
}
