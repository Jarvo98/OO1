package ar.edu.unlp.info.oo1;

import java.math.BigInteger;
import java.time.LocalDate;

public class PersonaJuridica extends Cliente {

    private long cuit;
    private String tipo;

    public PersonaJuridica(String nombre, String direccion, int numero, long cuit, String tipo) {
        super(nombre, direccion, numero);
        this.cuit = cuit;
        this.tipo = tipo;
    }

    @Override
    protected double calcularMontoTotalEnPeriodo(LocalDate desde, LocalDate hasta) {
        return super.calcularValorDeLlamadasEnPeriodo(desde, hasta);
    }
}
