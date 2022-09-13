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

    public Mamifero getAbueloMaterno() {
        if (this.getMadre() != null) {
            return this.getMadre().getPadre();
        } else {
            return null;
        }
    }

    public Mamifero getAbuelaMaterna() {
        if (this.getMadre() != null) {
            return this.getMadre().getMadre();
        } else {
            return null;
        }
    }

    public Mamifero getAbueloPaterno() {
        if (this.getPadre() != null) {
            return this.getPadre().getPadre();
        } else {
            return null;
        }
    }

    public Mamifero getAbuelaPaterna() {
        if (this.getPadre() != null) {
            return this.getPadre().getMadre();
        } else {
            return null;
        }
    }

    public boolean tieneComoAncestroA(Mamifero unMamifero) {
        return this.tieneComoAncestroA(unMamifero, true);
    }

    private boolean tieneComoAncestroA(Mamifero unMamifero, boolean esRaiz) {
        return
                (!esRaiz && this.equals(unMamifero))
                ||
                (this.getPadre() != null && this.getPadre().tieneComoAncestroA(unMamifero, false))
                ||
                (this.getMadre() != null && this.getMadre().tieneComoAncestroA(unMamifero, false));
    }

    public boolean equals(Mamifero unMamifero) {
        return this
                .getIdentificador()
                .equals(unMamifero.getIdentificador());
    }
}
