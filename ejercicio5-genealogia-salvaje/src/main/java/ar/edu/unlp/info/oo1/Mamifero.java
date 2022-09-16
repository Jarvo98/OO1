package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.Optional;

public class Mamifero {
    private String identificador;
    private String especie;
    private LocalDate fechaNacimiento;
    private Mamifero padre;
    private Mamifero madre;

    public Mamifero() {

    }

    public Mamifero(String unIdentificador) {
        this.identificador = unIdentificador;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getEspecie() {
        return this.especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Mamifero getPadre() {
        return this.padre;
    }

    public void setPadre(Mamifero padre) {
        this.padre = padre;
    }

    public Mamifero getMadre() {
        return this.madre;
    }

    public void setMadre(Mamifero madre) {
        this.madre = madre;
    }

    private boolean tengoPadre() {
        return this.getPadre() != null;
    }

    private boolean tengoMadre() {
        return this.getMadre() != null;
    }

    public Mamifero getAbueloMaterno() {
        return this.tengoMadre() ? this.getMadre().getPadre() : null;
    }

    public Mamifero getAbuelaMaterna() {
        return this.tengoMadre() ? this.getMadre().getMadre() : null;
    }

    public Mamifero getAbueloPaterno() {
        return this.tengoPadre() ? this.getPadre().getPadre() : null;
    }

    public Mamifero getAbuelaPaterna() {
        return this.tengoPadre() ? this.getPadre().getMadre() : null;
    }

    public boolean tieneComoAncestroA(Mamifero unMamifero) {
        return this.tieneComoAncestroA(unMamifero, true);
    }

    private boolean tieneComoAncestroA(Mamifero unMamifero, boolean esRaiz) {
        return
                (!esRaiz && this.equals(unMamifero))
                ||
                (this.tengoPadre() && this.getPadre().tieneComoAncestroA(unMamifero, false))
                ||
                (this.tengoMadre() && this.getMadre().tieneComoAncestroA(unMamifero, false));
    }

    public boolean equals(Mamifero unMamifero) {
        return this
                .getIdentificador()
                .equals(unMamifero.getIdentificador());
    }
}
