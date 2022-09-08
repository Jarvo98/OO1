package ar.edu.info.oo1.ej4_figuras;

public class Circulo extends Figura {

    private double radio;

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getDiametro() {
        return  this.getRadio() * 2;
    }

    public void setDiametro(double diametro) {
        this.radio = diametro / 2;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.getRadio(), 2);
    }

    @Override
    public double getPerimetro() {
        return Math.PI * this.getDiametro();
    }


}
