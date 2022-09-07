package ar.edu.info.oo1.ej3_presupuestos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Presupuesto {
    private LocalDate fecha;
    private String cliente;
    private Collection<Item> items;

    public Presupuesto() {
        this.fecha = LocalDate.now();
        this.items = new ArrayList<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Presupuesto fecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public String getCliente() {
        return cliente;
    }

    public Presupuesto cliente(String cliente) {
        this.cliente = cliente;
        return this;
    }

    public void agregarItem(Item item) {
        this.items.add(item);
    }

    public double calcularTotal() {
        return this
                .items
                .stream()
                .mapToDouble(item -> item.costo())
                .sum();
    }
}
