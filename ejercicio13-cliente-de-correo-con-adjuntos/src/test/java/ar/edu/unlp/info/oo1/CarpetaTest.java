package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarpetaTest {

    private Carpeta carpeta;

    @BeforeEach
    public void setUp() {
        this.carpeta = new Carpeta("ejemplo");
    }

    @Test
    public void espacioOcupadoTest() {
        Email email1 = new Email("12345", "1234567890");
        Email email2 = new Email("12345", "1234567890");

        this.carpeta.agregarEmail(email1);
        this.carpeta.agregarEmail(email2);

        assertEquals(30, this.carpeta.espacioOcupado());
    }
}
