package ar.edu.unlp.info.oo1.ej9.cuenta.con.ganchos;

public class CajaDeAhorro extends Cuenta {

    private double comision;

    public CajaDeAhorro() {
        super();
        this.comision = 0.02;
    }

    @Override
    protected boolean puedeExtraer(double monto) {
        return monto > 0 && monto <= this.calcularMaximoSaldoExtraible();
    }

    @Override
    public void depositar(double monto) {
        super.depositar(this.calcularMontoSinComision(monto));
    }

    @Override
    protected void extraerSinControlar(double monto) {
        super.extraerSinControlar(this.calcularMontoConComision(monto));
    }

    private double calcularMaximoSaldoExtraible() {
        return this.getSaldo() + (this.getSaldo() * this.getComision());
    }

    private double calcularMontoSinComision(double monto) {
        return monto - this.calcularComisionDeMonto(monto);
    }

    private double calcularMontoConComision(double monto) {
        return monto + this.calcularComisionDeMonto(monto);
    }

    private double calcularComisionDeMonto(double monto) {
        return monto * this.getComision();
    }

    private double getComision() {
        return this.comision;
    }
}
