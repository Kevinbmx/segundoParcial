/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import dto.Transaccion;
import java.util.ArrayList;

/**
 *
 * @author Uway
 */
public abstract class TransaccionDao {
     public abstract int insert(Transaccion obj) throws Exception;

    public abstract void update(Transaccion obj) throws Exception;

    public abstract void delete(int id);

    public abstract ArrayList<Transaccion> getList();

    public abstract Transaccion get(int id);
}
