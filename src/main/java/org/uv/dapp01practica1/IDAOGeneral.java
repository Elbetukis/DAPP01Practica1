/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.dapp01practica1;

import java.util.List;

/**
 *
 * @author alber
 */
public interface IDAOGeneral<T, ID> {
    public boolean guardar(T pojo);
    public boolean modificar(T pojo, ID id);
    public boolean eliminar(ID id);
    public T buscarById(ID id);
    public List<T> buscarAll();
    
}
