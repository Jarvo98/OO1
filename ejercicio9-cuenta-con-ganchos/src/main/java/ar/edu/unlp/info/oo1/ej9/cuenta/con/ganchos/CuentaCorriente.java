package ar.edu.unlp.info.oo1.ej9.cuenta.con.ganchos;

public class CuentaCorriente extends Cuenta {

    private double descubierto;

    public CuentaCorriente() {
        super();
        this.descubierto = 0;
    }

    public void setDescubierto(double descubierto) {
        this.descubierto = descubierto;
    }

    public double getDescubierto() {
        return descubierto;
    }

    @Override
    protected boolean puedeExtraer(double monto) {
        return (monto > 0) && !this.montoAExtraerSuperaDescubierto(monto);
    }

    private boolean montoAExtraerSuperaDescubierto(double monto) {
        return (-1 * this.getDescubierto()) >= (this.getSaldo() - monto);
    }
}
