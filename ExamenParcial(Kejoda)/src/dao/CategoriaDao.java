/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Categoria;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public abstract class CategoriaDao {

    public abstract int insert(Categoria obj) throws Exception;

    public abstract void update(Categoria obj) throws Exception;

    public abstract void delete(int id);

    public abstract ArrayList<Categoria> getList();

    public abstract ArrayList<Categoria> ListCategoria();

    public abstract Categoria get(int id);
    
    public abstract Categoria obtenernombreid(String nombrecategoria);
}
