package ar.edu.unlp.info.oo1;

public abstract class Pieza {

    private String material;
    private String color;

    protected Pieza(String material, String color) {
        this.material = material;
        this.color = color;
    }

    public abstract double getVolumen();

    public abstract double getSuperficie();

    public boolean esDeEsteMaterial(String material) {
        return this.material.equals(material);
    }

    public boolean esDeEsteColor(String color) {
        return this.color.equals(color);
    }
}
