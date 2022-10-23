package ar.edu.unlp.info.oo1.ticket;

import ar.edu.unlp.info.oo1.producto.Producto;

import java.time.LocalDate;
import java.util.Collection;

public class Ticket {

    private LocalDate fecha;
    private Collection<Producto> productos;
    private static final double impuesto = 0.21;

    public Ticket(LocalDate unaFecha, Collection<Producto> unosProductos) {
        this.fecha = unaFecha;
        this.productos = unosProductos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Collection<Producto> getProductos() {
        return this.productos;
    }

    public int getCantidadDeProductos() {
        return this
                .getProductos()
                .size();
    }

    public double getPesoTotal() {
        return this
                .getProductos()
                .stream()
                .mapToDouble(Producto::getPeso)
                .sum();
    }

    public double getPrecioTotal() {
        return this
                .getProductos()
                .stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
    }

    public double impuesto() {
        return this.getPrecioTotal() * Ticket.impuesto;
    }
}
