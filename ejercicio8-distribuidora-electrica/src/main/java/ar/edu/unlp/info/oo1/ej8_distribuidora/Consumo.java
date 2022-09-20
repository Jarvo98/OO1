package ar.edu.unlp.info.oo1.ej8_distribuidora;

import java.time.LocalDate;

public class Consumo implements Comparable {
    private LocalDate fecha;
    private double consumoEnergiaActiva;
    private double consumoEnergiaReactiva;

    public Consumo(LocalDate fecha, double consumoEnergiaActiva, double consumoEnergiaReactiva) {
        this.fecha = fecha;
        this.consumoEnergiaActiva = consumoEnergiaActiva;
        this.consumoEnergiaReactiva = consumoEnergiaReactiva;
    }

    public double costoEnBaseA(double precioKWh) {
        return this.getConsumoEnergiaActiva() * precioKWh;
    }

    public double factorDePotencia() {
        return
                this.getConsumoEnergiaActiva()
                        / Math.sqrt(
                                Math.pow(this.getConsumoEnergiaActiva(), 2)
                                        + Math.pow(this.getConsumoEnergiaReactiva(), 2)
                        );
    }

    public double getConsumoEnergiaActiva() {
        return this.consumoEnergiaActiva;
    }

    private double getConsumoEnergiaReactiva() {
        return this.consumoEnergiaReactiva;
    }

    @Override
    public int compareTo(Object consumo) {
        return this.fecha.compareTo(((Consumo) consumo).fecha);
    }

    public double calcularDescuento() {
        return (this.factorDePotencia() > 0.8) ? 10 : 0;
    }
}
