package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

public class ClienteDeCorreo {

    private Carpeta inbox;
    private Collection<Carpeta> carpetas;

    public ClienteDeCorreo(Carpeta inbox) {
        this.inbox = inbox;
        this.carpetas = new ArrayList<Carpeta>();
    }

    public void recibir(Email email) {
        this.inbox.agregarEmail(email);
    }

    public void mover(Email email, Carpeta origen, Carpeta destino) {
        origen.quitarEmail(email);
        destino.agregarEmail(email);
    }

    public Email buscar(String texto) {
        try {
            return this
                    .getCarpetasTotal()
                    .stream()
                    .filter(carpeta -> carpeta.contieneEmailConTexto(texto))
                    .findFirst()
                    .orElseThrow()
                    .buscar(texto);
        } catch (NoSuchElementException exception) {
            return null;
        }
    }

    public int espacioOcupado() {
        return this
                .getCarpetasTotal()
                .stream()
                .mapToInt(Carpeta::espacioOcupado)
                .sum();
    }

    public boolean recibioElCorreo(Email email) {
        return this
                .getCarpetasTotal()
                .stream()
                .anyMatch(carpeta -> carpeta.contieneEmail(email));
    }

    public int getCantidadDeCorreosEnInbox() {
        return this.inbox.getCantidadDeEmails();
    }

    public void agregarCarpeta(Carpeta carpeta) {
        this.carpetas.add(carpeta);
    }

    public boolean tieneElCorreoEnLaCarpeta(Email email, Carpeta carpeta) {
        try {
            return this.carpetas
                    .stream()
                    .filter(carpetaStream -> carpeta == carpetaStream)
                    .findFirst()
                    .orElseThrow()
                    .contieneEmail(email);
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    private List<Carpeta> getCarpetasTotal() {
        List<Carpeta> carpetasTotal = new ArrayList<>(this.carpetas);
        carpetasTotal.add(this.inbox);
        return carpetasTotal;
    }
}
