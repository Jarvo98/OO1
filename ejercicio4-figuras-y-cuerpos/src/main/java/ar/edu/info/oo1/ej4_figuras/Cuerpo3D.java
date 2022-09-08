package ar.edu.info.oo1.ej4_figuras;

public class Cuerpo3D {
    private double altura;
    private Figura caraBasal;

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    private Figura getCaraBasal () {
        return this.caraBasal;
    }

    public void setCaraBasal(Figura caraBasal) {
        this.caraBasal = caraBasal;
    }

    public double getVolumen() {
        return this.getAltura() * this.getCaraBasal().getArea();
    }

    public double getSuperficieExterior() {
        return (2 * this.getCaraBasal().getArea()) +
                (this.getCaraBasal().getPerimetro() * this.getAltura());
    }
}
