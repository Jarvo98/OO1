package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.Collection;

public class Inversor {

    private String nombre;
    private Collection<Inversion> inversiones;

    public Inversor(String nombre) {
        this.nombre = nombre;
        this.inversiones = new ArrayList<>();
    }

    public Inversor agregarInversion(Inversion inversion) {
        this.inversiones.add(inversion);
        return this;
    }

    public int getCantidadDeInversiones() {
        return this.inversiones.size();
    }

    public double valorActual() {
        return this.inversiones
                .stream()
                .mapToDouble(Inversion::valorActual)
                .sum();
    }

    public void eliminarInversiones() {
        this.inversiones = new ArrayList<>();
    }
}
