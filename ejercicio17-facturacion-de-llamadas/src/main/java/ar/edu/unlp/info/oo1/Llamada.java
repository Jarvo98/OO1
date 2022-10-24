package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Llamada {

    private LocalDateTime fechaHora;
    private double duracionEnMinutos;
    private int numeroEmisor;
    private int numeroReceptor;

    protected Llamada(LocalDateTime fechaHora, double duracionEnMinutos, int numeroEmisor, int numeroReceptor) {
        this.fechaHora = fechaHora;
        this.duracionEnMinutos = duracionEnMinutos;
        this.numeroEmisor = numeroEmisor;
        this.numeroReceptor = numeroReceptor;
    }

    public boolean fueHechaEnPeriodo(LocalDate fechaDeInicio, LocalDate fechaDeFin) {
        LocalDate fechaDeLaLlamada = this.fechaHora.toLocalDate();

        return (fechaDeInicio.equals(fechaDeLaLlamada) || fechaDeInicio.isBefore(fechaDeLaLlamada))
                && (fechaDeFin.isAfter(fechaDeLaLlamada) || fechaDeFin.equals(fechaDeLaLlamada));
    }

    public abstract double calcularCosto();

    protected double getDuracionEnMinutos() {
        return this.duracionEnMinutos;
    }

    protected LocalDateTime getFechaHora() {
        return this.fechaHora;
    }
}
