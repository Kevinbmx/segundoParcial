package dto;

public class Cuenta {

    private int CuentaId;
    private String nombreCuenta;
    private int monto;
    private int usuarioId;

    public Cuenta() {
        ;
    }

    public int getCuentaId() {
        return CuentaId;
    }

    public void setCuentaId(int CuentaId) {
        this.CuentaId = CuentaId;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
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

    
}
