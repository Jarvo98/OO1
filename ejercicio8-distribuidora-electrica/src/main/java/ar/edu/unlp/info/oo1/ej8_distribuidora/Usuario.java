package ar.edu.unlp.info.oo1.ej8_distribuidora;

import java.util.*;

public class Usuario {
    private String domicilio;
    private String nombre;
    private Collection<Factura> facturas;
    private SortedSet<Consumo> consumos;

    public Usuario(String nombre, String domicilio) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.facturas = new ArrayList<>();
        this.consumos = new TreeSet<>();
    }

    public void agregarMedicion(Consumo medicion) {
        this.getConsumos().add(medicion);
    }

    public double ultimoConsumoActiva() {
        try {
            return this.ultimoConsumo().getConsumoEnergiaActiva();
        } catch (NoSuchElementException exception) {
            return 0.0;
        }
    }

    public Factura facturarEnBaseA(double precioKWh) {
        return new Factura(
                this.calcularMontoEnergiaActiva(precioKWh),
                this.calcularDescuento(),
                this
        );
    }

    private double calcularMontoEnergiaActiva(double precioKWh) {
        try {
            return this.ultimoConsumo().costoEnBaseA(precioKWh);
        } catch (NoSuchElementException exception) {
            return 0;
        }
    }

    private double calcularDescuento() {
        try {
            return this.ultimoConsumo().calcularDescuento();
        } catch (NoSuchElementException exception) {
            return 0;
        }
    }

    public Collection<Factura> facturas() {
        return this.facturas;
    }

    public Consumo ultimoConsumo() throws NoSuchElementException {
        try {
            return this.getConsumos().last();
        } catch (NoSuchElementException exception) {
            throw exception;
        }
    }

    private SortedSet<Consumo> getConsumos() {
        return this.consumos;
    }
}
