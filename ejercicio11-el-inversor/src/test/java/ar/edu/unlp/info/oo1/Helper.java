package ar.edu.unlp.info.oo1;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Helper {

    public static Helper getInstance() {
        return new Helper();
    }

    private LocalDate fecha;
    private double monto;
    private double porcentaje;

    private Helper() {
        this.fecha = LocalDate.of(2022, 9, 1);
        this.monto = 15000;
        this.porcentaje = 1;
    }

    public LocalDate getFecha() {
        return LocalDate.from(this.fecha);
    }

    public double getMonto() {
        return this.monto;
    }

    public double getPorcentaje() {
        return this.porcentaje;
    }

    public double calcularTotal() {
        return this.getMonto() + this.calcularInteres();
    }

    private double calcularInteres() {
        return this.getMonto() * ChronoUnit.DAYS.between(this.fecha, LocalDate.now()) * (this.getPorcentaje() / 100);
    }
}
