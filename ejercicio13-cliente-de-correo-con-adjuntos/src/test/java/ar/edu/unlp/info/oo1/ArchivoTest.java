package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArchivoTest {

    private Archivo archivo;

    @BeforeEach
    public void setUp() {
        this.archivo = new Archivo("1234567890");
    }

    @Test
    public void tamanioTest() {
        assertEquals(10, this.archivo.tamanio());
    }
}
