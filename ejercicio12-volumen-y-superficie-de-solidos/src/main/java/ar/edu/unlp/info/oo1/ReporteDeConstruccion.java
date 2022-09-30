package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.Collection;

public class ReporteDeConstruccion {

    private Collection<Pieza> piezas;

    public ReporteDeConstruccion() {
        this.piezas = new ArrayList<Pieza>();
    }

    public double volumenDeMaterial(String material) {
        return this.piezas
                .stream()
                .filter(pieza -> pieza.esDeEsteMaterial(material))
                .mapToDouble(Pieza::getVolumen)
                .sum();
    }

    public double superficieDeColor(String color) {
        return this.piezas
                .stream()
                .filter(pieza -> pieza.esDeEsteColor(color))
                .mapToDouble(Pieza::getSuperficie)
                .sum();
    }

    public ReporteDeConstruccion agregarPieza(Pieza pieza) {
        this.piezas.add(pieza);
        return this;
    }
}
