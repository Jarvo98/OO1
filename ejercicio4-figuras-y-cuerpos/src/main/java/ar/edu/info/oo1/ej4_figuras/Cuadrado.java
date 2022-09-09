package ar.edu.info.oo1.ej4_figuras;

public class Cuadrado implements Figura {

    private double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double getArea() {
        return Math.pow(this.getLado(), 2);
    }

    @Override
    public double getPerimetro() {
        return this.getLado() * 4;
    }
}
