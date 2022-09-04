package ar.edu.unlp.info.oo1.balanza;

import ar.edu.unlp.info.oo1.producto.Producto;
import ar.edu.unlp.info.oo1.ticket.Ticket;

import java.time.LocalDate;

public class Balanza {

    private int cantidadDeProductos;
    private double precioTotal;
    private double pesoTotal;

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public Balanza setCantidadDeProductos(int cantidadDeProductos) {
        this.cantidadDeProductos = cantidadDeProductos;
        return this;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public Balanza setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
        return this;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public Balanza setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
        return this;
    }

    public void ponerEnCero() {
        this.setCantidadDeProductos(0)
                .setPrecioTotal(0)
                .setPesoTotal(0);
    }
    public void agregarProducto(Producto producto) {
        this.setPrecioTotal(this.getPrecioTotal() + producto.getPrecio())
                .setPesoTotal(this.getPesoTotal() + producto.getPeso())
                .setCantidadDeProductos(this.getCantidadDeProductos() + 1);
    }
    public Ticket emitirTicket() {
        return new Ticket(LocalDate.now(), this.getCantidadDeProductos(), this.getPesoTotal(), this.getPrecioTotal());
    }
}
