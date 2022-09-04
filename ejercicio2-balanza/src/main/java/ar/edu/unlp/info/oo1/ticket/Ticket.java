package ar.edu.unlp.info.oo1.ticket;

import java.time.LocalDate;

public class Ticket {

    private LocalDate fecha;
    private int cantidadDeProductos;
    private double pesoTotal;
    private double precioTotal;
    private static final double impuesto = 0.21;

    public Ticket(LocalDate unaFecha, int unaCantidadDeProductos, double unPesoTotal, double unPrecioTotal) {
        this.fecha = unaFecha;
        this.cantidadDeProductos = unaCantidadDeProductos;
        this.pesoTotal = unPesoTotal;
        this.precioTotal = unPrecioTotal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public void setCantidadDeProductos(int cantidadDeProductos) {
        this.cantidadDeProductos = cantidadDeProductos;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double impuesto() {
        return this.getPrecioTotal() * Ticket.impuesto;
    }
}
