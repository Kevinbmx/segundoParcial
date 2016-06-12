/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * @author Jonathan
 */
public class Transferencia {
    
    private int idtransferencia, idcuentaorigen, idcuentadestino;
    private String descripcion;
    private Date fecha;
    private float monto;

    public Transferencia() {
        ;
    }

    public int getIdtransferencia() {
        return idtransferencia;
    }

    public void setIdtransferencia(int idtransferencia) {
        this.idtransferencia = idtransferencia;
    }

    public int getIdcuentaorigen() {
        return idcuentaorigen;
    }

    public void setIdcuentaorigen(int idcuentaorigen) {
        this.idcuentaorigen = idcuentaorigen;
    }

    public int getIdcuentadestino() {
        return idcuentadestino;
    }

    public void setIdcuentadestino(int idcuentadestino) {
        this.idcuentadestino = idcuentadestino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    
}
