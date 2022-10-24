package ar.edu.unlp.info.oo1;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class LlamadaInternacional extends Llamada {

    private String paisDeOrigen;
    private String paisDeDestino;

    public LlamadaInternacional(LocalDateTime fechaHora, double duracionEnMinutos, int numeroEmisor, int numeroReceptor, String paisDeOrigen, String paisDeDestino) {
        super(fechaHora, duracionEnMinutos, numeroEmisor, numeroReceptor);
        this.paisDeOrigen = paisDeOrigen;
        this.paisDeDestino = paisDeDestino;
    }

    @Override
    public double calcularCosto() {
        return this.getDuracionEnMinutos() * this.decidirCostoPorMinuto();
    }

    private double decidirCostoPorMinuto() {
        return this.llamadaRealizadaEnHorarioDiurno() ? 4 : 3;
    }

    private boolean llamadaRealizadaEnHorarioDiurno() {
        LocalTime comienzo = LocalTime.of(8, 0, 0);
        LocalTime fin = LocalTime.of(20, 0, 0);
        LocalTime actual = this.getFechaHora().toLocalTime();

        return (comienzo.equals(actual) || comienzo.isBefore(actual)) && fin.isAfter(actual);
    }
}
