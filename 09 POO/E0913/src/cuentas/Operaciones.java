package cuentas;

public interface Operaciones {
    
    public void ingreso(double cantidad);
    public void cargo(double cantidad);
    public void transferencia(CuentaCorriente c, double cantidad);
}
