/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Mascota;
import interfaces.IMascota;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 * @author Juan Carlos
 */
public class MascotaDao implements IMascota{

    @Override
    public void guardarMascota(Mascota mascota) {
        //Construir una nueva session y una nueva transaccion
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        
        //Registrar en la base de datos la mascota
        sesion.save(mascota);
        transaccion.commit();
        
        sesion.close();
        
    
    }

    @Override
    public ArrayList<Mascota> listarMascotas(Session sesion) {
        ArrayList<Mascota> milista = new ArrayList<>();
        //Crear la consulta hacia la base de datos
        Query query = sesion.createQuery("FROM Mascota");
        
        //Ejecutar la consulta y obtener la lista
        milista = (ArrayList<Mascota>)query.list();
        
        return milista;
    
    }
    
}
