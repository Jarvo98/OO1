package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteDeCorreoTest {

    private Carpeta inbox;
    private ClienteDeCorreo clienteDeCorreo;
    private Email email1;
    private Email email2;

    @BeforeEach
    public void setUp() {
        this.inbox = new Carpeta("inbox");
        this.clienteDeCorreo = new ClienteDeCorreo(this.inbox);
        this.email1 = new Email("Hola Jesus", "Me comunico con vos para blabla...");
        this.email2 = new Email("Buen dia", "Este es un mensaje para recordarle que ...");

        this.clienteDeCorreo.recibir(this.email1);
        this.clienteDeCorreo.recibir(this.email2);
    }

    @Test
    public void recibirTest() {
        assertTrue(this.clienteDeCorreo.recibioElCorreo(email1));
        assertTrue(this.clienteDeCorreo.recibioElCorreo(email2));
        assertEquals(2, this.clienteDeCorreo.getCantidadDeCorreosEnInbox());
    }

    @Test
    public void moverTest() {
        Carpeta carpeta1 = new Carpeta("trabajo");

        this.clienteDeCorreo.agregarCarpeta(carpeta1);
        this.clienteDeCorreo.mover(this.email1, this.inbox, carpeta1);
        assertTrue(this.clienteDeCorreo.tieneElCorreoEnLaCarpeta(this.email1, carpeta1));
    }

    @Test
    public void buscarTest() {
        assertEquals(this.email1, this.clienteDeCorreo.buscar("Hola Jesus"));
        assertEquals(this.email2, this.clienteDeCorreo.buscar("Este es un mensaje para recordarle que ..."));
        assertNull(this.clienteDeCorreo.buscar("Este valor no deberia existir"));
    }

    @Test
    public void espacioOcupadoTest() {
        Email email3 = new Email("CV", "Buen dia. Dejo adjunto mi CV para la posicion de ...");
        email3.agregarAdjunto(new Archivo("CV Jesus Rojas.pdf"));

        this.clienteDeCorreo.recibir(email3);
        assertEquals(166, this.clienteDeCorreo.espacioOcupado());
    }
}
