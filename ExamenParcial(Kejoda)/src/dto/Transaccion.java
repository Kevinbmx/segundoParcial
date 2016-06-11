/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

public class Transaccion {

    private int idTransaccion;
    private float monto;
    private String Fecha;
    private int FK_idCategoria;
    private int Fk_idcuenta;
    private String tipo;

    public Transaccion() {
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getFK_idCategoria() {
        return FK_idCategoria;
    }

    public void setFK_idCategoria(int FK_idCategoria) {
        this.FK_idCategoria = FK_idCategoria;
    }

    public int getFk_idcuenta() {
        return Fk_idcuenta;
    }

    public void setFk_idcuenta(int Fk_idcuenta) {
        this.Fk_idcuenta = Fk_idcuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
