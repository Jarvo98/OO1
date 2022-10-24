package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class Factura {

    private LocalDate fechaDeFacturacion;
    private LocalDate desde;
    private LocalDate hasta;
    private double montoTotal;
    private Cliente cliente;

    public Factura(LocalDate desde, LocalDate hasta, double montoTotal, Cliente cliente) {
        this.desde = desde;
        this.hasta = hasta;
        this.montoTotal = montoTotal;
        this.cliente = cliente;
        this.fechaDeFacturacion = LocalDate.now();
    }

    public double getMontoTotal() {
        return this.montoTotal;
    }
}
