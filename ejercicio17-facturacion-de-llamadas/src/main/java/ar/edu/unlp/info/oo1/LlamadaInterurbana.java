package ar.edu.unlp.info.oo1;

import java.time.LocalDateTime;

public class LlamadaInterurbana extends Llamada {

    private double distanciaEnKilometros;

    public LlamadaInterurbana(LocalDateTime fechaHora, double duracionEnMinutos, int numeroEmisor, int numeroReceptor, double distanciaEnKilometros) {
        super(fechaHora, duracionEnMinutos, numeroEmisor, numeroReceptor);
        this.distanciaEnKilometros = distanciaEnKilometros;
    }

    @Override
    public double calcularCosto() {
        double costoDeConexion = 5;

        return costoDeConexion + this.calcularCostoBasadoEnDistancia();
    }

    private double calcularCostoBasadoEnDistancia() {
        return this.getDuracionEnMinutos() * this.decidirCostoPorMinuto();
    }

    private double decidirCostoPorMinuto() {
        if (this.distanciaEnKilometros < 100)
            return 2;
         else if (this.distanciaEnKilometros >= 100 && this.distanciaEnKilometros <= 500)
            return 2.5;
         else
            return 3;
    }
}
