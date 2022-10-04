package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.Collection;

public class Carpeta {

    private String nombre;
    private Collection<Email> emails;

    public Carpeta(String nombre) {
        this.nombre = nombre;
        this.emails = new ArrayList<Email>();
    }

    public void agregarEmail(Email email) {
        this.emails.add(email);
    }

    public int espacioOcupado() {
        return this.emails
                .stream()
                .mapToInt(Email::espacioOcupado)
                .sum();
    }

    public String getNombre() {
        return nombre;
    }

    public boolean contieneEmail(Email email) {
        return this.emails.contains(email);
    }

    public int getCantidadDeEmails() {
        return this.emails.size();
    }

    public void quitarEmail(Email email) {
        this.emails.remove(email);
    }

    public boolean contieneEmailConTexto(String texto) {
        return this.emails
                .stream()
                .anyMatch(email -> email.contieneTexto(texto));
    }

    public Email buscar(String texto) {
        return this.emails
                .stream()
                .filter(email -> email.contieneTexto(texto))
                .findFirst()
                .get();
    }
}
