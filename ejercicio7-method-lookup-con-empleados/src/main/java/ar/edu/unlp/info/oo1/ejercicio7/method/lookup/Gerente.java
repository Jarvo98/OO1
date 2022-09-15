package ar.edu.unlp.info.oo1.ejercicio7.method.lookup;

public class Gerente extends EmpleadoJerarquico {

    public Gerente(String unNombre) {
        this.setNombre(unNombre);
    }

    public double aportes() {
        return this.montoBasico() * 0.05d;
    }

    public double montoBasico() {
        return 57000;
    }
}
