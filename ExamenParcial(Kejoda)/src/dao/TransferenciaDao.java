/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Categoria;
import dto.Transferencia;
import java.util.ArrayList;

/**
 *
 * @author Jonathan
 */
public abstract class TransferenciaDao {
    
    public abstract int insert(Transferencia obj) throws Exception;

    public abstract void update(Transferencia obj) throws Exception;

    public abstract int delete(int id);

    public abstract ArrayList<Transferencia> getList();

    public abstract ArrayList<Transferencia> ListCategoria();

    public abstract Transferencia get(int id);
    
}
