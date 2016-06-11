/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Cuenta;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public abstract class CuentaDao {

    public abstract int insert(Cuenta obj) throws Exception;

    public abstract void update(Cuenta obj) throws Exception;

    public abstract void delete(int id);

    public abstract ArrayList<Cuenta> getList();

    public abstract Cuenta get(int id);
    
    public abstract float montoTotal(Cuenta obj);
}
