package ar.edu.unlp.info.oo1;

import java.time.LocalDateTime;

public class LlamadaLocal extends Llamada {

    public LlamadaLocal(LocalDateTime fechaHora, double duracionEnMinutos, int numeroEmisor, int numeroReceptor) {
        super(fechaHora, duracionEnMinutos, numeroEmisor, numeroReceptor);
    }

    @Override
    public double calcularCosto() {
        int costoPorMinuto = 1;

        return costoPorMinuto * this.getDuracionEnMinutos();
    }

}
