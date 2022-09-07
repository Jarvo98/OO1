package ar.edu.info.oo1.ej3_presupuestos;

public class Item {
    private String detalle;
    private int cantidad;
    private double costoUnitario;

    public String getDetalle() {
        return detalle;
    }

    public Item detalle(String detalle) {
        this.detalle = detalle;
        return this;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Item cantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public Item costoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
        return this;
    }

    public double costo() {
        return this.getCostoUnitario() * this.getCantidad();
    }
}
