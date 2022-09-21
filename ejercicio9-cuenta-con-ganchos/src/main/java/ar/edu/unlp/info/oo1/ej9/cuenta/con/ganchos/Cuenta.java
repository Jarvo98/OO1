package ar.edu.unlp.info.oo1.ej9.cuenta.con.ganchos;

public abstract class Cuenta {
    private double saldo;

    public Cuenta() {
        this.saldo = 0;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void depositar(double monto) {
        if (this.puedeDepositar(monto))
            this.depositarSinControlar(monto);
    }

    protected void extraerSinControlar(double monto) {
        this.saldo -= monto;
    }

    private void depositarSinControlar(double monto) {
        this.saldo += monto;
    }

    public boolean extraer(double monto) {
        if (this.puedeExtraer(monto)) {
            this.extraerSinControlar(monto);
            return true;
        }
        return false;
    }

    public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
        if (this.puedeExtraer(monto)) {
            this.extraerSinControlar(monto);
            cuentaDestino.depositar(monto);
            return true;
        }
        return false;
    }

    protected abstract boolean puedeExtraer(double monto);

    private boolean puedeDepositar(double monto) {
        return monto > 0;
    }
}
