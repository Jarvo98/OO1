package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import static java.lang.Math.floor;

public class PlazoFijo implements Inversion {

    private double montoDepositado;
    private double factorDeConversion;
    private LocalDate fechaDeConstitucion;

    public PlazoFijo(double montoDepositado, double porcentajeDeInteresDiario, LocalDate fechaDeConstitucion) {
        this.montoDepositado = montoDepositado;
        this.factorDeConversion = porcentajeDeInteresDiario / 100;
        this.fechaDeConstitucion = fechaDeConstitucion;
    }

    @Override
    public double valorActual() {
        return this.montoDepositado + this.calcularIntereses();
    }

    private double calcularIntereses() {
        return (this.montoDepositado * this.factorDeConversion) * this.calcularDiasDesdeConstitucion();
    }

    private int calcularDiasDesdeConstitucion() {
        return (int) floor(this.fechaDeConstitucion.until(LocalDate.now(), ChronoUnit.DAYS));
    }
}
