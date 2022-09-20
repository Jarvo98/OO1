package ar.edu.unlp.info.oo1.ej8_distribuidora;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Distribuidora {
    private double precioKWh;
    private Collection<Usuario> usuarios;

    public Distribuidora(double precioKWh) {
        this.precioKWh = precioKWh;
        this.usuarios = new ArrayList<>();
    }

    public Collection<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void agregarUsuario(Usuario usuario) {
        this.getUsuarios().add(usuario);
    }

    public Collection<Factura> facturar() {
        return this
                .getUsuarios()
                .stream()
                .map(
                        usuario -> usuario.facturarEnBaseA(this.getPrecioKW()))
                .collect(Collectors.toList());
    }

    public double consumoTotalActiva() {
        return this
                .getUsuarios()
                .stream()
                .mapToDouble(Usuario::ultimoConsumoActiva)
                .sum();
    }

    public void precioKWh(double precio) {
        this.precioKWh = precio;
    }

    public double getPrecioKW() {
        return this.precioKWh;
    }
}
