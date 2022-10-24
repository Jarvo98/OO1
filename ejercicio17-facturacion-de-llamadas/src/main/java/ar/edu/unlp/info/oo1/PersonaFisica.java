package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class PersonaFisica extends Cliente {

    private int dni;

    public PersonaFisica(String nombre, String direccion, int numero, int dni) {
        super(nombre, direccion, numero);
        this.dni = dni;
    }


    @Override
    protected double calcularMontoTotalEnPeriodo(LocalDate desde, LocalDate hasta) {
        return super.calcularValorDeLlamadasEnPeriodo(desde, hasta) * 0.9;
    }
}
