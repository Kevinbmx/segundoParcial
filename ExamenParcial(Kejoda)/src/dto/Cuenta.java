package dto;

public class Cuenta {

    private int CuentaId;
    private String nombreCuenta;
    private float monto;
    private int usuarioId;
    private float montoTotal;

    public Cuenta() {
        ;
    }

    public int getCuentaId() {
        return CuentaId;
    }

    public void setCuentaId(int CuentaId) {
        this.CuentaId = CuentaId;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreUsuario) {
        this.nombreCuenta = nombreUsuario;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    
    
}
