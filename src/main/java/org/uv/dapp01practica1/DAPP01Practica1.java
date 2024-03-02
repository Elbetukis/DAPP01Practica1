/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.uv.dapp01practica1;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author alber
 */
public class DAPP01Practica1 {

   public static void main(String[] args) {
       SessionFactory sf = HibernateUtil.getSessionFactory();
            Venta venta = new Venta();
            venta.setCliente("publico general");
            venta.setFecha(new Date(new java.util.Date().getTime()));
            venta.setTotal(100000);

            List<VentaDetalle> lstDetalleVenta = new ArrayList<>();
            for (int i = 0; i < 5;
                    i++) {
                VentaDetalle det = new VentaDetalle();
                det.setPrecio(1000);
                det.setCantidad(10);
                det.setProducto("Producto "+ i);
                det.setVenta(venta);
            }
            venta.setDetalleVenta(lstDetalleVenta);
            
            
            Session session = sf.getCurrentSession();
            Transaction transaction = session.beginTransaction();
            session.save(venta);
            transaction.commit();
            System.out.println("Se guardo con ID:" + venta.getId());
        
    }
}
