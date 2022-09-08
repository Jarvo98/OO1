package ar.edu.unlp.info.oo1.balanza;

import ar.edu.unlp.info.oo1.producto.Producto;
import ar.edu.unlp.info.oo1.ticket.Ticket;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Balanza {

    private Collection<Producto> productos;

    public Balanza() {
        this.productos = new ArrayList<>();
    }

    public Collection<Producto> getProductos() {
        return this.productos;
    }

    public int getCantidadDeProductos() {
        return this.getProductos().size();
    }

    public double getPrecioTotal() {
        return this
                .getProductos()
                .stream()
                .mapToDouble(producto -> producto.getPrecio())
                .sum();
    }

    public double getPesoTotal() {
        return this
                .getProductos()
                .stream()
                .mapToDouble(producto -> producto.getPeso())
                .sum();
    }

    public void ponerEnCero() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        this.getProductos().add(producto);
    }

    public Ticket emitirTicket() {
        return new Ticket(LocalDate.now(), this.getProductos());
    }
}
