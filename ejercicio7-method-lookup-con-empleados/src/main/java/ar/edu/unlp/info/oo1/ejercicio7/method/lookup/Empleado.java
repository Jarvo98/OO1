package ar.edu.unlp.info.oo1.ejercicio7.method.lookup;

public class Empleado {
    private String nombre;

    protected void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public double aportes() {
        return 13500;
    }

    public double montoBasico() {
        return 35000;
    }

    public double sueldoBasico() {
        return this.montoBasico() + this.aportes();
    }
}
